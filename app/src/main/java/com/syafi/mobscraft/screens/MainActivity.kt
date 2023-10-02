package com.syafi.mobscraft.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafi.mobscraft.R
import com.syafi.mobscraft.adapter.ListMobAdapter
import com.syafi.mobscraft.databinding.ActivityMainBinding
import com.syafi.mobscraft.model.Mob

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var rvMob: RecyclerView
    private val mobList= ArrayList<Mob>()

    override fun onCreate(savedInstanceState: Bundle?) {

        bind= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        if (supportActionBar != null) {
            supportActionBar!!.show()
        }

        rvMob= bind.rvMob
        rvMob.setHasFixedSize(true)

        mobList.addAll(getMobList())
        showRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_about -> {
                val toAbout= Intent(this, AboutActivity::class.java)
                startActivity(toAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getMobList(): ArrayList<Mob> {

        val dataName= resources.getStringArray(R.array.data_name)
        val dataBehavior= resources.getStringArray(R.array.data_behavior)
        val dataPhoto= resources.obtainTypedArray(R.array.data_photo)
        val dataDescription= resources.getStringArray(R.array.data_description)
        val dataHp= resources.getStringArray(R.array.data_hp)

        val list= ArrayList<Mob>()

        for (i in dataName.indices) {
            val mob= Mob(
                name = dataName[i],
                hp = dataHp[i],
                behavior = dataBehavior[i],
                description = dataDescription[i],
                photo = dataPhoto.getResourceId(i, -1)
            )
            list.add(mob)
        }
        return list
    }

    private fun showRecyclerView() {
        rvMob.layoutManager= LinearLayoutManager(this)
        val listMobAdapter= ListMobAdapter(mobList)
        rvMob.adapter= listMobAdapter
    }
}