package com.prongbang.cryptocurrency.presentation

import androidx.lifecycle.ViewModel
import com.prongbang.cryptocurrency.data.CryptocurrencyRepository
import com.prongbang.cryptocurrency.domain.Charter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
internal class CryptocurrencyViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
) : ViewModel() {
    val charters: Flow<Result<Charter>> = cryptocurrencyRepository.getCharter()
}