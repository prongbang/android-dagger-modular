import dependencies.Libs
import plugins.`module-plugin`

plugins {
	id("com.android.library")
	`module-plugin`
}

dependencies {
	implementation(Libs.Coroutines.core)
	implementation(Libs.Dagger.Hilt.core)

	kapt(Libs.Dagger.Hilt.compiler)
}