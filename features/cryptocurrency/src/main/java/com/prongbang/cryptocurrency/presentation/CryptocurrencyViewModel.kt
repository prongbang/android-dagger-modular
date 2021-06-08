package com.prongbang.cryptocurrency.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.prongbang.cryptocurrency.data.CryptocurrencyRepository
import com.prongbang.cryptocurrency.domain.Charter
import kotlinx.coroutines.flow.Flow

internal class CryptocurrencyViewModel @ViewModelInject constructor(
		private val cryptocurrencyRepository: CryptocurrencyRepository
) : ViewModel() {
	val charters: Flow<Result<Charter>> = cryptocurrencyRepository.getCharter()
}