package com.prongbang.cryptocurrency.data

import com.prongbang.cryptocurrency.domain.Charter
import retrofit2.http.GET

interface CryptocurrencyApi {

	@GET("bpi/currentprice.json")
	suspend fun getCharter(): Charter
}