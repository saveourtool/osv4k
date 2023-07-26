plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.saveourtool.osv4k"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.run {
                jvmTarget = "1.8"
            }
        }
    }
    linuxX64()
    mingwX64()
    macosX64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.json)
                api(libs.kotlinx.datetime)
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.jetbrains.annotations)
            }
        }
        val commonNonJvmMain by creating {
            dependsOn(commonMain)
        }
        listOf(
            "linuxX64",
            "mingwX64",
            "macosX64",
        ).forEach { nonJvmTarget ->
            getByName("${nonJvmTarget}Main").dependsOn(commonNonJvmMain)
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmMain by getting {
            dependencies {
                api(libs.jackson.annotations)
                api(libs.jackson.databind)
            }
        }
    }
}
