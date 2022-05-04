package plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.Project

internal class FlavorPlugin : CompositePlugin {

    override fun apply(target: Project) {
        val androidExtension = target.extensions.findByName("android")
        if (androidExtension !is BaseExtension) return

        androidExtension.flavorDimensions("environment", "platform")
        androidExtension.productFlavors {
            create("mock") {
                dimension = "environment"
                if (target.name == "app") {
                    applicationIdSuffix = ".mock"
                }
                configDeepLinkField("myapp-mock")
            }
            create("develop") {
                dimension = "environment"
                if (target.name == "app") {
                    applicationIdSuffix = ".dev"
                }
                configDeepLinkField("myapp-dev")
            }
            create("uat") {
                dimension = "environment"
                if (target.name == "app") {
                    applicationIdSuffix = ".uat"
                }
                configDeepLinkField("myapp-uat")
            }
            create("production") {
                dimension = "environment"
                configDeepLinkField("myapp")
            }
            create("google") {
                dimension = "platform"
            }
            create("huawei") {
                dimension = "platform"
            }
        }
    }

    private fun ProductFlavor.configDeepLinkField(scheme: String) {
        addManifestPlaceholders(mapOf("DEEPLINK_SCHEME" to scheme))
        buildConfigField("String", "DEEPLINK_SCHEME", "\"$scheme\"")
    }
}