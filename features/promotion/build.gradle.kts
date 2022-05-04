import dependencies.Libs
import dependencies.Test

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("module-plugin")
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project(":commons:network"))
    implementation(Libs.Coroutines.core)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Ktx.fragment)
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.AndroidX.LifeCycle.viewModel)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation(Libs.Dagger.Hilt.jetPack)
    implementation(Libs.Dagger.Hilt.android)
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    kapt(Libs.Dagger.Hilt.jetPackCompiler)
    kapt(Libs.Dagger.Hilt.androidCompiler)
    testImplementation(Test.jUnit)
    testImplementation(Test.truth)
    testImplementation(Test.mockitoKotlin)
    testImplementation(Test.coroutne)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}
