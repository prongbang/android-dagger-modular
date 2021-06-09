import dependencies.Libs
import dependencies.Test
import plugins.`module-plugin`

plugins {
	id("com.android.application")
	id("dagger.hilt.android.plugin")
	`module-plugin`
}

android {
	defaultConfig.applicationId = "com.prongbang.adm"
}

dependencies {
	implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
	implementation(project(":features:cryptocurrency"))
	implementation(project(":commons:network"))
	implementation(Libs.stdlibJdk8)
	implementation(Libs.AndroidX.appCompat)
	implementation(Libs.AndroidX.constraintLayout)
	implementation(Libs.AndroidX.Ktx.core)
	implementation(Libs.AndroidX.LifeCycle.runtime)
	implementation(Libs.Dagger.Hilt.android)
	implementation(Libs.Dagger.Hilt.jetPack)
	implementation("com.google.android.material:material:1.3.0")

	kapt(Libs.Dagger.Hilt.androidCompiler)
	kapt(Libs.Dagger.Hilt.jetPackCompiler)

	testImplementation(Test.jUnit)
	androidTestImplementation(Test.Esspresso.jUnit)
	androidTestImplementation(Test.Esspresso.core)
}