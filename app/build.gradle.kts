@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version Versions.ksp
}

android {
    namespace = "io.vinicius.common"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.vinicius.common"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        // This is needed so Ktlint works properly
        configureEach {
            java.srcDir("src/$name/kotlin")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.activity_compose)
    implementation(Deps.compose_material3)
    implementation(Deps.compose_navigation)
    implementation(Deps.compose_ui)
    implementation(Deps.compose_ui_tooling_preview)
    implementation(Deps.core_ktx)
    implementation(Deps.coroutines_android)
    implementation(Deps.coroutines_core)
    implementation(Deps.lifecycle_ktx)
    implementation(Deps.material_icons)
    implementation(Deps.moshi)
    implementation(Deps.okhttp)
    implementation(Deps.okhttp_logging)
    implementation(Deps.retrofit)
    implementation(Deps.retrofit_moshi)

    ksp(Deps.moshi_codegen)

    debugImplementation(Deps.compose_ui_tooling)
    debugImplementation(Deps.compose_ui_test)
}