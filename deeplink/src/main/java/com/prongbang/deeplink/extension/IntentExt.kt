package com.prongbang.deeplink.extension

import android.content.Intent
import android.os.Bundle
import com.prongbang.deeplink.router.DeepLinkRouter

fun Intent.putDeepLinkExtra(session: String) {
	putExtra(DeepLinkRouter.IS_DEEP_LINK_EXTRA, true)
	putExtras(Bundle(extras).apply {
		putString("session", session)
	})
}

fun Intent.hasClass(cls: Class<*>): Boolean {
	return this.component?.className?.let { Class.forName(it) == cls } ?: false
}