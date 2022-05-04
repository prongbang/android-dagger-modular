package com.prongbang.deeplink.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.prongbang.deeplink.module.AppDeepLinkModule
import com.prongbang.deeplink.module.AppDeepLinkModuleRegistry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@DeepLinkHandler(AppDeepLinkModule::class)
class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeepLinkDelegate(AppDeepLinkModuleRegistry()).apply {
            dispatchFrom(this@DeepLinkActivity)
        }
        finish()
    }
}