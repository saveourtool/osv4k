/**
 * Precompiled script plugin, that applies common configuration for a KMP project.
 * It specifies common targets and sets some common compiler flags.
 * It creates a number of useful source sets and adds common dependencies.
 * These source sets can be retrieved in a particular build script and configured further as needed.
 */

package com.saveourtool.osv4k.buildutils

import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvmToolchain(11)
}

configureVersioning()
// withJava() creates a task for jacoco
// configureJacoco()
configureDiktat()
configureDetekt()

tasks.withType<KotlinJvmTest> {
    useJUnitPlatform()
}
