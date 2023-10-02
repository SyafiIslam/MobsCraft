package com.syafi.mobscraft.screens

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.syafi.mobscraft.R
import com.syafi.mobscraft.databinding.ActivityDetailBinding
import com.syafi.mobscraft.model.Mob
import com.syafi.mobscraft.util.Constant

class DetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        val mob = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Mob>(Constant.EXTRA_MOB, Mob::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mob>(Constant.EXTRA_MOB)
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = mob?.name
        }

        if (mob != null) {

            bind.apply {
                Glide
                    .with(this@DetailActivity)
                    .load(mob.photo)
                    .into(ivPhoto)

                tvName.text = mob.name
                tvBehaviour.text= mob.behavior
                tvHp.text= getString(R.string.mob_hp, mob.hp)
                tvDescription.text= mob.description
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}