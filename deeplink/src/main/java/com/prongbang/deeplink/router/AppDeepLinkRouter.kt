package com.prongbang.deeplink.router

import android.content.Intent
import javax.inject.Inject

class AppDeepLinkRouter @Inject constructor(
    private val router: Set<@JvmSuppressWildcards DeepLinkRouter>
) : DeepLinkRouter {

    override fun route(uri: String): Intent? {
        for (r in router) {
            val intent = r.route(uri)
            if (intent != null) return intent
        }
        return null
    }

}