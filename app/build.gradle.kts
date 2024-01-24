

plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.apollo)
}

android {
    namespace = "io.vinicius.common"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.vinicius.common"
        targetSdk = 33
        minSdk = 30
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.accompanist.navigation)
    implementation(libs.activity.compose)
    implementation(libs.apollo.api)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.core.ktx)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.koin.compose)
    implementation(libs.lifecycle.ktx)
    implementation(libs.material.icons)
    implementation(libs.sak.network)
    implementation(libs.sak.util)
    implementation(libs.sak.view)
    implementation(libs.timber)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test)
}

apollo {
    service("service") {
        packageName.set("io.vinicius.common.graphql")
    }
}