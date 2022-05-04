package com.prongbang.deeplink.router

import com.prongbang.deeplink.router.promotion.PromotionDeepLinkRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
interface DeepLinkRouterModule {

	@IntoSet
	@Binds
	fun providePromotionRouter(deepLinkRouter: PromotionDeepLinkRouter): DeepLinkRouter

	// TODO provide other deeplink router

}