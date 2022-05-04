package com.prongbang.deeplink.receiver

import android.content.BroadcastReceiver

abstract class DeepLinkReceiver : BroadcastReceiver() {
	abstract fun register()
	abstract fun unregister()
}