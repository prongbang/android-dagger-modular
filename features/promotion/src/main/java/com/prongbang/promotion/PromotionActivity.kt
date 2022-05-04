package com.prongbang.promotion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PromotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent().apply { }
        }
    }
}