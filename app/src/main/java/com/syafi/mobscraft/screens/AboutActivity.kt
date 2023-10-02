package com.syafi.mobscraft.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syafi.mobscraft.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title= "About"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}