package com.prongbang.deeplink

import com.prongbang.deeplink.receiver.AppDeepLinkReceiver
import com.prongbang.deeplink.receiver.DeepLinkReceiver
import com.prongbang.deeplink.router.DeepLinkRouter
import com.prongbang.deeplink.router.AppDeepLinkRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class DeepLinkModule {

    @Provides
    fun provideAppDeepLinkRouter(deepLinkRouter: AppDeepLinkRouter): DeepLinkRouter =
        deepLinkRouter

    @Provides
    fun provideAppDeepLinkReceiver(
        deepLinkReceiver: AppDeepLinkReceiver
    ): DeepLinkReceiver = deepLinkReceiver
}