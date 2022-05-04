import dependencies.Libs
import dependencies.Test

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("module-plugin")
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project(":features:promotion"))
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.Broadcast.manager)
    implementation(Libs.AndroidX.Ktx.fragment)
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.Airbnb.deeplinkDispatch)
    kapt(Libs.Airbnb.deeplinkDispatchProcessor)
    implementation(Libs.Dagger.Hilt.jetPack)
    implementation(Libs.Dagger.Hilt.android)
    implementation(Libs.Coroutines.core)
    kapt(Libs.Dagger.Hilt.jetPackCompiler)
    kapt(Libs.Dagger.Hilt.androidCompiler)
    testImplementation(Test.jUnit)
    testImplementation(Test.truth)
    testImplementation(Test.mockitoKotlin)
    testImplementation(Test.coroutne)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}