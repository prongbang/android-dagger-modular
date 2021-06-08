package com.prongbang.cryptocurrency.data

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.prongbang.cryptocurrency.domain.Charter
import com.prongbang.cryptocurrency.domain.Time
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

@ExperimentalCoroutinesApi
class DefaultCryptocurrencyRepositoryTest {

	private val api = mock<CryptocurrencyApi>()

	@Test
	fun `emits mapped api results`() = runBlockingTest {
		val charter = Charter(emptyMap(), "", "", Time(""))
		val expectedCharter = charter
		given(api.getCharter()).willReturn(charter)

		val sut = DefaultCryptocurrencyRepository(api)

		val actual = sut.getCharter()
				.first()

		assertThat(actual.isSuccess)
		assertThat(expectedCharter).isEqualTo(actual.getOrNull())
	}

	@Test
	fun `emits exception`() = runBlockingTest {
		Result.failure<Charter>(IllegalStateException())
		given(api.getCharter()).willThrow(IllegalStateException())

		val sut = DefaultCryptocurrencyRepository(api)

		val actual = sut.getCharter()
				.first()

		assertThat(actual.isFailure)
	}
}