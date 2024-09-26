import org.jetbrains.kotlin.config.JvmTarget

plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.apollo)
}

android {
    namespace = "io.vinicius.common"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.vinicius.common"
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JvmTarget.JVM_17.description
    }
    buildFeatures {
        buildConfig = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.navigation.compose)
    implementation(libs.activity.compose)
    implementation(libs.apollo.api)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.core.ktx)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.lifecycle.ktx)
    implementation(libs.material.icons)
    implementation(libs.sak.network)
    implementation(libs.sak.util)
    implementation(libs.sak.view)
    implementation(libs.timber)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)
    implementation(libs.koin.navigation)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test)
}

apollo {
    service("service") {
        packageName.set("io.vinicius.common.graphql")
    }
}