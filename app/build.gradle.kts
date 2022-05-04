import dependencies.Libs
import dependencies.Test

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("module-plugin")
}

android {
    defaultConfig {
        applicationId = "com.prongbang.modular"
        versionCode = 1
        versionName = "1.0.0"
    }

    signingConfigs {
        create("release") {
            storeFile = file("myreleasekey.keystore")
            storePassword = "password"
            keyAlias = "MyReleaseKey"
            keyPassword = "password"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project(":deeplink"))
    implementation(project(":features:cryptocurrency"))
    implementation(project(":commons:network"))
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation(Libs.Dagger.Hilt.android)
    implementation(Libs.Dagger.Hilt.jetPack)
    implementation(Libs.Android.material)

    kapt(Libs.Dagger.Hilt.androidCompiler)
    kapt(Libs.Dagger.Hilt.jetPackCompiler)

    testImplementation(Test.jUnit)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}