// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.android_app) version Versions.android apply false
    id(Plugins.android_lib) version Versions.android apply false
    id(Plugins.kotlin) version Versions.kotlin apply false
    id(Plugins.detekt) version Versions.detekt
    id(Plugins.ktlint) version Versions.ktlint
}

detekt {
    config = files("$rootDir/config/detekt.yml")
    source = files("$rootDir/app/src/main/kotlin")
}

ktlint {
    android.set(true)
}

subprojects {
    apply(plugin = Plugins.ktlint)
}