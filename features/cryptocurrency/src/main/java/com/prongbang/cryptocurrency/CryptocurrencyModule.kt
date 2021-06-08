package com.prongbang.cryptocurrency

import com.prongbang.cryptocurrency.data.CryptocurrencyApi
import com.prongbang.cryptocurrency.data.CryptocurrencyRepository
import com.prongbang.cryptocurrency.data.DefaultCryptocurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object CryptocurrencyModule {

	@Provides
	internal fun provideCryptocurrencyApi(retrofit: Retrofit): CryptocurrencyApi =
			retrofit.create(CryptocurrencyApi::class.java)

	@Provides
	internal fun provideCryptocurrencyRepository(repository: DefaultCryptocurrencyRepository)
			: CryptocurrencyRepository = repository
}