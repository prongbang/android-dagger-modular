package com.prongbang.cryptocurrency.domain

data class Charter(
		val bpi: Map<String, Bpi>,
		val disclaimer: String,
		val chartName: String,
		val time: Time,
)

data class Bpi(
		val code: String,
		val description: String,
		val symbol: String,
		val rate: String,
)

data class Time(val updated: String)