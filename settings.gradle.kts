rootProject.name = "osv4k"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.9.0")
            version("kotlinx-serialization", "1.5.1")
            version("kotlinx-datetime", "0.4.0")
            version("jackson", "2.15.2")

            plugin("kotlin-multiplatform", "org.jetbrains.kotlin.multiplatform")
                .versionRef("kotlin")
            plugin("kotlin-plugin-serialization", "org.jetbrains.kotlin.plugin.serialization")
                .versionRef("kotlin")

            library("jetbrains-annotations", "org.jetbrains:annotations:24.0.1")
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json")
                .versionRef("kotlinx-serialization")
            library("kotlinx-datetime", "org.jetbrains.kotlinx", "kotlinx-datetime")
                .versionRef("kotlinx-datetime")
            library("jackson-annotations", "com.fasterxml.jackson.core", "jackson-annotations")
                .versionRef("jackson")
            library("jackson-module-kotlin", "com.fasterxml.jackson.module", "jackson-module-kotlin")
                .versionRef("jackson")
            library("jackson-databind", "com.fasterxml.jackson.core", "jackson-databind")
                .versionRef("jackson")
            library("jackson-datatype-jsr310", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310")
                .versionRef("jackson")
        }
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.gradle.enterprise") version "3.13.3"
}

gradleEnterprise {
    @Suppress("AVOID_NULL_CHECKS")
    if (System.getenv("CI") != null) {
        buildScan {
            publishAlways()
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
    }
}
