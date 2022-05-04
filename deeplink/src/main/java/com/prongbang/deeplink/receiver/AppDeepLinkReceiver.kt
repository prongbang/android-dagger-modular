package com.prongbang.deeplink.receiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.prongbang.deeplink.router.DeepLinkRouter
import javax.inject.Inject

class AppDeepLinkReceiver @Inject constructor(
    private val context: Context,
    private val deepLinkRouter: DeepLinkRouter
) : DeepLinkReceiver() {

    private var deepLinkReceiver: DeepLinkReceiver? = null

    override fun onReceive(context: Context?, intent: Intent) {
        val deepLinkUri = intent.getStringExtra(DeepLinkHandler.EXTRA_URI) ?: ""
        if (intent.getBooleanExtra(DeepLinkHandler.EXTRA_SUCCESSFUL, false)) {
            deepLinkRouter.route(deepLinkUri)?.let {
                startActivity(context, it)
            }
        }
    }

    private fun startActivity(context: Context?, intent: Intent) {
        intent.apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            putExtra(DeepLinkRouter.IS_DEEP_LINK_EXTRA, true)
        }
            .also { context?.startActivity(intent) }
    }

    override fun register() {
        deepLinkReceiver = AppDeepLinkReceiver(
            context = context,
            deepLinkRouter = deepLinkRouter,
        ).also {
            val intentFilter = IntentFilter(DeepLinkHandler.ACTION)
            LocalBroadcastManager.getInstance(context)
                .registerReceiver(it, intentFilter)
        }
    }

    override fun unregister() {
        deepLinkReceiver?.let {
            LocalBroadcastManager.getInstance(context)
                .unregisterReceiver(it)
        }
        deepLinkReceiver = null
    }
}