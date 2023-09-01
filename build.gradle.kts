import com.saveourtool.osv4k.buildutils.configurePublishing
import com.saveourtool.osv4k.buildutils.createDetektTask

plugins {
    id("com.saveourtool.osv4k.buildutils.kotlin-library")
}

group = "com.saveourtool.cosv4k"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    val nonJvmTargets = setOf(
        linuxX64(),
        mingwX64(),
        macosX64(),
        js(IR) {
            browser()
            nodejs()
            useCommonJs()
        }
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
        nonJvmTargets.forEach { nativeTarget ->
            getByName("${nativeTarget.name}Main").dependsOn(commonNonJvmMain)
        }
        val jvmMain by getting {
            dependencies {
                api(libs.jackson.annotations)
                api(libs.jackson.databind)
            }
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(kotlin("test-junit5"))
            }
        }
    }
}

createDetektTask()
configurePublishing()

setOf("compileJava", "compileTestJava").forEach { taskName ->
    tasks.named<JavaCompile>(taskName) {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
