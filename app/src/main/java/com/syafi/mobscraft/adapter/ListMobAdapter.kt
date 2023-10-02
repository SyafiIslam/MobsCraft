package com.syafi.mobscraft.adapter

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syafi.mobscraft.R
import com.syafi.mobscraft.databinding.MobItemBinding
import com.syafi.mobscraft.model.Mob
import com.syafi.mobscraft.screens.DetailActivity
import com.syafi.mobscraft.util.Constant

class ListMobAdapter(private val listMob: ArrayList<Mob>):
    RecyclerView.Adapter<ListMobAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val bind= MobItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(bind)
    }

    override fun getItemCount(): Int =
        listMob.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val name= listMob[position].name
        val behavior= listMob[position].behavior
        val photo= listMob[position].photo

        holder.bind.tvMobName.text= name
        Glide
            .with(holder.itemView.context)
            .load(photo)
            .into(holder.bind.ivMobPhoto    )
        holder.bind.tvMobBehavior.text= behavior

        holder.itemView.setOnClickListener {
            val toDetail= Intent(holder.itemView.context, DetailActivity::class.java)
            toDetail.putExtra(Constant.EXTRA_MOB, listMob[position])
            holder.itemView.context.startActivity(toDetail)
        }
    }

    class ListViewHolder(var bind: MobItemBinding) : RecyclerView.ViewHolder(bind.root)
}