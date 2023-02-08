object Versions {
    const val activity_compose = "1.6.1"
    const val android = "7.4.1"
    const val android_sak = "main-SNAPSHOT"
    const val compose_material3 = "1.1.0-alpha05"
    const val compose_navigation = "2.5.3"
    const val compose_ui = "1.3.3"
    const val core_ktx = "1.9.0"
    const val coroutines = "1.6.4"
    const val detekt = "1.22.0"
    const val koin = "3.4.1"
    const val kotlin_android = "1.8.0"
    const val ksp = "1.8.0-1.0.9"
    const val ktlint = "11.1.0"
    const val lifecycle_ktx = "2.5.1"
    const val material_icons = "1.3.1"
    const val moshi = "1.14.0"
    const val retrofit = "2.9.0"
}

object Deps {
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose}"
    const val compose_material3 = "androidx.compose.material3:material3:${Versions.compose_material3}"
    const val compose_navigation = "androidx.navigation:navigation-compose:${Versions.compose_navigation}"
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose_ui}"
    const val compose_ui_test = "androidx.compose.ui:ui-test-manifest:${Versions.compose_ui}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_ui}"
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val koin_compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_ktx}"
    const val material_icons = "androidx.compose.material:material-icons-extended:${Versions.material_icons}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val sak_network = "com.github.vegidio.android-sak:network:${Versions.android_sak}"
    const val sak_view = "com.github.vegidio.android-sak:view:${Versions.android_sak}"
}