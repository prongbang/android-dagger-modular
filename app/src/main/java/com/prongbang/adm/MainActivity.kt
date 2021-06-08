package com.prongbang.adm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prongbang.cryptocurrency.presentation.CryptocurrencyFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.add(
							R.id.fragment_container,
							CryptocurrencyFragment(),
							CryptocurrencyFragment::class.java.simpleName
					)
					.commit()
		}
	}
}