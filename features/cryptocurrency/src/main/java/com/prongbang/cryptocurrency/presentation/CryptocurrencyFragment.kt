package com.prongbang.cryptocurrency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.prongbang.cryptocurrency.databinding.FragmentCryptocurrencyBinding
import com.prongbang.cryptocurrency.domain.Charter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptocurrencyFragment : Fragment() {

	private val viewModel by viewModels<CryptocurrencyViewModel>()
	private var resultJob: Job? = null
	private var _binding: FragmentCryptocurrencyBinding? = null
	private val binding get() = _binding!!


	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?
	): View {
		_binding = FragmentCryptocurrencyBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onStart() {
		super.onStart()
		resultJob = lifecycleScope.launch {
			viewModel.charters.collect { charterResult ->
				when {
					charterResult.isSuccess -> handleSuccess(charterResult.getOrNull()!!)
					charterResult.isFailure -> handleFailure(charterResult.exceptionOrNull()!!)
				}
			}
		}
	}

	override fun onStop() {
		resultJob?.cancel()
		super.onStop()
	}

	private fun handleSuccess(charter: Charter) {
		binding.name.text = charter.chartName
		binding.disclaimer.text = charter.disclaimer
		val bpiText = charter.bpi.map { bpiEntry -> bpiEntry.value }
				.joinToString("") {
					"${it.code}: ${it.rate}\n"
				}
		binding.bpi.text = bpiText
	}

	private fun handleFailure(throwable: Throwable) {
		Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_SHORT)
				.show()
	}

}