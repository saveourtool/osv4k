import com.saveourtool.osv4k.buildutils.createDetektTask

plugins {
    id("com.saveourtool.osv4k.buildutils.kotlin-library")
    id("com.saveourtool.osv4k.buildutils.publishing-configuration")
}

group = "com.saveourtool.osv4k"

repositories {
    mavenCentral()
}

createDetektTask()

kotlin {
    jvmToolchain(11)
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    val nativeTargets = setOf(
        linuxX64(),
        mingwX64(),
        macosX64(),
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.json)
                api(libs.kotlinx.datetime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.jetbrains.annotations)
            }
        }
        val commonNonJvmMain by creating {
            dependsOn(commonMain)
        }
        nativeTargets.forEach { nativeTarget ->
            getByName("${nativeTarget.name}Main").dependsOn(commonNonJvmMain)
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmMain by getting {
            dependencies {
                api(libs.jackson.annotations)
                api(libs.jackson.databind)
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(kotlin("test-junit5"))
            }
        }
    }
}

setOf("compileJava", "compileTestJava").forEach { taskName ->
    tasks.named<JavaCompile>(taskName) {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
