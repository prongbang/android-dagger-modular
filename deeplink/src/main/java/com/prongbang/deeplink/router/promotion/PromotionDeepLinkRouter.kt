package com.prongbang.deeplink.router.promotion

import android.content.Context
import android.content.Intent
import com.prongbang.deeplink.BuildConfig
import com.prongbang.deeplink.router.DeepLinkRouter
import com.prongbang.promotion.PromotionActivity
import javax.inject.Inject

class PromotionDeepLinkRouter @Inject constructor(
    private val context: Context
) : DeepLinkRouter {

    override fun route(uri: String): Intent? {
        if (matches(uri)) {
            return PromotionActivity.newIntent(context)
        }
        return null
    }

    private fun matches(uri: String): Boolean = SCHEME_PATTERN.matches(uri)

    companion object {
        private const val DEEPLINK_HOST = "promotion"
        const val DEEPLINK = "${BuildConfig.DEEPLINK_SCHEME}://$DEEPLINK_HOST"

        private val SCHEME_PATTERN = "(${BuildConfig.DEEPLINK_SCHEME}://$DEEPLINK_HOST)".toRegex()
    }
}