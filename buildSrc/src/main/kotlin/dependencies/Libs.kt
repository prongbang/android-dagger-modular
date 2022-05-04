package dependencies

object Libs {

	const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.21"

	const val okHttp = "com.squareup.okhttp3:okhttp:4.7.2"

	const val appStartUp = "androidx.startup:startup-runtime:1.0.0"

	object LeakCanary {
		private const val version = "2.4"
		const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$version"
		const val plumber = "com.squareup.leakcanary:plumber-android:$version"
	}

	object Coroutines {
		internal const val coroutineVersion = "1.4.2"
		const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
		const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
	}

	object Glide {
		private const val glideVersion = "4.11.0"
		const val core = "com.github.bumptech.glide:glide:$glideVersion"
		const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
		const val recyclerView = "com.github.bumptech.glide:recyclerview-integration:$glideVersion"
	}

	object Airbnb {
		const val deeplinkDispatch = "com.airbnb:deeplinkdispatch:6.1.0"
		const val deeplinkDispatchProcessor = "com.airbnb:deeplinkdispatch-processor:6.1.0"
	}

	object Android {
		const val material = "com.google.android.material:material:1.5.0"
	}

	object AndroidX {
		const val appCompat = "androidx.appcompat:appcompat:1.4.1"
		const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

		object Ktx {
			const val core = "androidx.core:core-ktx:1.7.0"
			const val fragment = "androidx.fragment:fragment-ktx:1.4.1"
			const val activity = "androidx.activity:activity-ktx:1.4.0"
		}

		object LifeCycle {
			private const val lifeCycleVersion = "2.4.1"
			const val runtime =  "androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion"
			const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion"
			const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
			const val test = "androidx.arch.core:core-testing:$lifeCycleVersion"
		}

		object Room {
			internal const val version = "2.4.2"

			const val core = "androidx.room:room-runtime:$version"
			const val processor = "androidx.room:room-compiler:$version"
			const val ktx = "androidx.room:room-ktx:$version"
		}

		object Navigation {
			internal const val version = "2.4.2"

			const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
			const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
			const val dynamicFeature =
					"androidx.navigation:navigation-dynamic-features-fragment:$version"
		}

		object WorkManager {
			internal const val version = "2.7.1"

			const val coreKtx = "androidx.work:work-runtime-ktx:$version"
		}

		object Hilt {
			const val common = "androidx.hilt:hilt-common:1.0.0"
			const val commonCompiler = "androidx.hilt:hilt-compiler:1.0.0"
			const val navigationFragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
			const val work = "androidx.hilt:hilt-work:1.0.0"
		}

		object Broadcast {
			const val manager = "androidx.localbroadcastmanager:localbroadcastmanager:1.1.0"
		}
	}

	object Dagger {
		private const val daggerVersion = "2.38.1"
		const val core = "com.google.dagger:dagger:$daggerVersion"
		const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"

		object Hilt {
			private const val jetPackVersion = "1.0.0-alpha03"
			private const val version = "2.38.1"

			const val android = "com.google.dagger:hilt-android:$version"
			const val core = "com.google.dagger:hilt-core:$version"
			const val compiler = "com.google.dagger:hilt-compiler:$version"
			const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
			const val jetPack = "androidx.hilt:hilt-lifecycle-viewmodel:$jetPackVersion"
			const val jetPackCompiler = "androidx.hilt:hilt-compiler:$jetPackVersion"
		}
	}

	object Stetho {
		private const val stethoVersion = "1.5.1"
		const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
		const val stethoOk = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"
	}

	object Retrofit {
		private const val retrofitVersion = "2.9.0"
		const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
		const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
		const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
	}

	object Moshi {
		private const val moshiVersion = "1.9.3"
		const val core = "com.squareup.moshi:moshi:$moshiVersion"
		const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
	}
}