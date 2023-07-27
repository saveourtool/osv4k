/**
 * Configuration for diktat static analysis
 */

package com.saveourtool.osv4k.buildutils

import org.cqfn.diktat.plugin.gradle.DiktatExtension
import org.cqfn.diktat.plugin.gradle.DiktatGradlePlugin
import org.cqfn.diktat.plugin.gradle.DiktatJavaExecTaskBase
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

/**
 * Applies diktat gradle plugin and configures diktat for [this] project
 */
fun Project.configureDiktat() {
    apply<DiktatGradlePlugin>()
    configure<DiktatExtension> {
        diktatConfigFile = rootProject.file("diktat-analysis.yml")
        githubActions = findProperty("diktat.githubActions")?.toString()?.toBoolean() ?: false
        inputs {
            include(
                "buildSrc/src/**/*.kt",
                "buildSrc/**/*.kts",
                "*.kts",
                "src/**/*.kt",
                "src/**/*.kts",
            )
            exclude("build", "buildSrc/build")
        }
    }
    fixDiktatTask()
}

private fun Project.fixDiktatTask() {
    tasks.withType<DiktatJavaExecTaskBase>().configureEach {
        // https://github.com/saveourtool/diktat/issues/1269
        systemProperty("user.home", rootDir.toString())
    }
}
