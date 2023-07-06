package com.adrian.talentclassrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000 // Waktu jeda splash screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        supportActionBar?.hide()

        // Mengatur jeda waktu dan pindah ke activity berikutnya
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri Splash Activity agar tidak dapat kembali ke Splash Screen lagi
        }, splashTimeOut)
    }
}