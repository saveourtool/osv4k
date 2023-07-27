plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // workaround https://github.com/gradle/gradle/issues/15383
    implementation(files(project.libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradle.plugin) {
        because("Add plugin on plugin classpath here to automatically set its version for the whole build")
    }
    implementation(libs.diktat.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
    implementation(libs.kotlin.plugin.serialization)
    // implementation("io.github.gradle-nexus:publish-plugin:1.3.0")
    implementation("org.ajoberstar.reckon:reckon-gradle:0.13.2")
    // implementation("org.ajoberstar.reckon:reckon-gradle:0.18.0")
}
