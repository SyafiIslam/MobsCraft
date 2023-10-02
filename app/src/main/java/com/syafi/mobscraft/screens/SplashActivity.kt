package com.syafi.mobscraft.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.syafi.mobscraft.R
import com.syafi.mobscraft.util.Constant

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intentToMainActivity= Intent(this, MainActivity::class.java)
            startActivity(intentToMainActivity)
        }, Constant.SPLASH_DURATION)
    }
}