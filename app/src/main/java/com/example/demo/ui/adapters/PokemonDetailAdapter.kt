package com.example.demo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.databinding.DetailItemBinding
import com.example.demo.domain.model.Abilities

class PokemonDetailAdapter() : RecyclerView.Adapter<PokemonDetailAdapter.ViewHolder>() {
    private val items: MutableList<Abilities> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonDetailAdapter.ViewHolder {
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.detail_item, parent, false
        )
        return ViewHolder(view)
    }

    fun addData(list: List<Abilities>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PokemonDetailAdapter.ViewHolder, position: Int) {
        (holder).onBind(getItem(position))
    }

    private fun getItem(position: Int):Abilities{
        return items[position]
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val dataBinding: ViewDataBinding): RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(item: Abilities) {
            val listItem = dataBinding as DetailItemBinding
            listItem.tvName.text = "Ability Name : ${item.ability.name}"
            listItem.tvUrl.text = "More Info : ${item.ability.url}"
        }

    }

}