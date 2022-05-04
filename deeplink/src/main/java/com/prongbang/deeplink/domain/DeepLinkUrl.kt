package com.prongbang.deeplink.domain

import com.prongbang.deeplink.BuildConfig

data class DeepLinkUrl(val host: String, val contentId: String, val others: String) {
    companion object {
        val LINK_PATTERN = "${BuildConfig.DEEPLINK_SCHEME}://([\\w-]+)/([\\w-]+)/?(.*)".toRegex()
        fun parse(url: String): DeepLinkUrl {
            val matchResult = LINK_PATTERN.find(url)?.groupValues ?: emptyList()
            val host = matchResult.getOrNull(1) ?: ""
            val contentId = matchResult.getOrNull(2) ?: ""
            val others = matchResult.getOrNull(3) ?: ""
            return DeepLinkUrl(host, contentId, others)
        }
    }
}