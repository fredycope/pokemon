package com.example.demo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.databinding.ListItemBinding
import com.example.demo.domain.model.Results
import com.example.demo.utils.OnClickList
import com.google.gson.Gson

class PokemonAdapter(val onClickList: OnClickList) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private val items: MutableList<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.list_item, parent, false
        )
        return ViewHolder(view)
    }

    fun addData(list: List<Results>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        (holder).onBind(getItem(position))
    }

    private fun getItem(position: Int):Results{
        return items[position]
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val dataBinding: ViewDataBinding): RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(item: Results) {
            val listItem = dataBinding as ListItemBinding
            listItem.tvTitle.text = item.name

            itemView.setOnClickListener {
                onClickList.goToFragment(item.url.toString() ,it)
            }
        }

    }

}