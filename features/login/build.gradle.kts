import dependencies.Libs
import dependencies.Test
import plugins.`module-plugin`

plugins {
	id("com.android.library")
	id("dagger.hilt.android.plugin")
	id("kotlin-android")
	`module-plugin`
}

dependencies {
	implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
	implementation(project(":commons:network"))
	implementation(Libs.stdlibJdk8)
	implementation(Libs.Coroutines.core)
	implementation(Libs.AndroidX.appCompat)
	implementation(Libs.AndroidX.constraintLayout)
	implementation(Libs.AndroidX.Ktx.fragment)
	implementation(Libs.AndroidX.Ktx.core)
	implementation(Libs.AndroidX.LifeCycle.viewModel)
	implementation(Libs.AndroidX.LifeCycle.runtime)
	implementation(Libs.Dagger.Hilt.jetPack)
	implementation(Libs.Dagger.Hilt.android)
	implementation("androidx.appcompat:appcompat:1.3.0")
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
