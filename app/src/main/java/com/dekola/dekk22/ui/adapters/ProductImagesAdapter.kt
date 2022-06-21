package com.dekola.dekk22.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dekola.dekk22.databinding.ListItemProductImageBinding

class ProductImagesAdapter : ListAdapter<String, ProductImagesViewHolder>(ProductImagesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImagesViewHolder {
        val binding =
            ListItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ProductImagesDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
}

class ProductImagesViewHolder(private val binding: ListItemProductImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String?) {
        Glide.with(binding.root.context).load(imageUrl).into(binding.productImg)
    }

}