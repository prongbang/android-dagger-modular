import dependencies.Libs

plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id("module-plugin")
}

dependencies {
	implementation(Libs.Coroutines.core)
	implementation(Libs.Dagger.Hilt.core)

	kapt(Libs.Dagger.Hilt.compiler)
}