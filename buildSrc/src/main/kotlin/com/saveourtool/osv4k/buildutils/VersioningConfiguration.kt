/**
 * Version configuration file.
 */

package com.saveourtool.osv4k.buildutils

import org.ajoberstar.reckon.gradle.ReckonPlugin
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.internal.storage.file.FileRepository
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Configures how project version is determined.
 *
 * @throws GradleException if there was an attempt to run release build with dirty working tree
 */
fun Project.configureVersioning() {
    apply<ReckonPlugin>()
}

private fun Project.failOnUncleanTree() {
    val status = FileRepositoryBuilder()
        .findGitDir(project.rootDir)
        .setup()
        .let(::FileRepository)
        .let(::Git)
        .status()
        .call()
    if (!status.isClean) {
        throw GradleException("Release build will be performed with not clean git tree; aborting. " +
                "Untracked files: ${status.untracked}, uncommitted changes: ${status.uncommittedChanges}")
    }
}
