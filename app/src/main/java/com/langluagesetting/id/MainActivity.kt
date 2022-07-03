package com.langluagesetting.id

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.langluagesetting.id.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mAdView : AdView
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-8604728728100888/8748349796"


        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adview)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        open()
    }

    private fun open() {
        mainBinding.apply {
            startid.setOnClickListener {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
            }
        }
    }
}