package com.prongbang.deeplink.router

import android.content.Intent

interface DeepLinkRouter {
	fun route(uri: String): Intent?

	companion object {
		const val IS_DEEP_LINK_EXTRA = "IS_DEEP_LINK_EXTRA"
	}
}