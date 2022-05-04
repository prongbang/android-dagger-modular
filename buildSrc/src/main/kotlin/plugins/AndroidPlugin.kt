package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal class AndroidPlugin : CompositePlugin {

    override fun apply(target: Project) {
        val androidExtension = target.extensions.findByName("android")
        if (androidExtension !is BaseExtension) return

        applyDefaultConfigurations(androidExtension)
    }

    private fun applyDefaultConfigurations(androidExtension: BaseExtension) {
        androidExtension.compileSdkVersion(SDK_COMPILE_VERSION)
        androidExtension.buildToolsVersion(BUILD_TOOLS_VERSION)

        androidExtension.defaultConfig {

            targetSdk = SDK_TARGET_VERSION
            minSdk = SDK_MIN_VERSION

            vectorDrawables.useSupportLibrary = true
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        androidExtension.buildFeatures.viewBinding = true

        androidExtension.lintOptions {
            isAbortOnError = false
        }
    }

    companion object {
        private const val SDK_COMPILE_VERSION = 31
        private const val BUILD_TOOLS_VERSION = "30.0.3"
        private const val SDK_TARGET_VERSION = SDK_COMPILE_VERSION
        private const val SDK_MIN_VERSION = 21
    }
}