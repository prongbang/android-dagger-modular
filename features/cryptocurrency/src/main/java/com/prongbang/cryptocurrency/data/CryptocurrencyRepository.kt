package com.prongbang.cryptocurrency.data

import com.prongbang.cryptocurrency.domain.Charter
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface CryptocurrencyRepository {
	fun getCharter(): Flow<Result<Charter>>
}

class DefaultCryptocurrencyRepository  @Inject constructor(
		private val cryptocurrencyApi: CryptocurrencyApi
) : CryptocurrencyRepository {

	override fun getCharter(): Flow<Result<Charter>> {
		return flow {
			while (true) {
				try {
					val charter = cryptocurrencyApi.getCharter()
					emit(Result.success(charter))
					delay(1000)
				} catch (cancellation: CancellationException) {
					throw cancellation
				} catch (ex: Exception) {
					emit(Result.failure<Charter>(ex))
				}
			}
		}
	}

}