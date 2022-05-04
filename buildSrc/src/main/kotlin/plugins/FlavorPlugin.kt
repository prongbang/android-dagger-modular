package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal class FlavorPlugin : CompositePlugin {

    override fun apply(target: Project) {
        val androidExtension = target.extensions.findByName("android")
        if (androidExtension !is BaseExtension) return

//        androidExtension.buildTypes {
//            getByName("release") {
//                minifyEnabled(true)
//                proguardFiles(
//                    androidExtension.getDefaultProguardFile("proguard-android.txt"),
//                    "proguard-rules.pro"
//                )
//            }
//            getByName("debug") {
//                debuggable(true)
//            }
//            getByName("develop") {
//                applicationIdSuffix = ".dev"
//                debuggable(true)
//            }
//            getByName("uat") {
//                applicationIdSuffix = ".uat"
//                debuggable(true)
//            }
//        }
//
//        androidExtension.productFlavors {
//            create("google") {
//            }
//            create("huawei") {
//            }
//        }
    }
}