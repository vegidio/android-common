// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.app) apply false
    alias(libs.plugins.android.lib) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

detekt {
    config = files("$rootDir/config/detekt.yml")
    source = files("$rootDir/app/src/main/kotlin")
}

ktlint {
    android.set(true)
}