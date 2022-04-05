package com.burningfriday.getyourpokemon.modern.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.getyourpokemon.R
import com.android.getyourpokemon.databinding.ModernListItemLayoutBinding
import com.burningfriday.getyourpokemon.network.api.model.Pokemon

class ModernListAdapter : ListAdapter<Pokemon, ModernListAdapter.ListViewHolder>(diffUtil) {

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem

        }
    }

    inner class ListViewHolder constructor(private val binding: ModernListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pokemon) {
            binding.pokemon = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: ModernListItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.modern_list_item_layout,
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}