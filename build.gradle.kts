// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.android apply false
    id("com.android.library") version Versions.android apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin_android apply false
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
}

detekt {
    source = files("$rootDir/app/src/main/kotlin")
    config = files("$rootDir/config/detekt.yml")
}