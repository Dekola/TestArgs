package com.dekola.dekk22.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.databinding.ListItemProductBinding

class ProductListAdapter(private val viewProductDetails: (ProductPresentation) -> Unit) :
    ListAdapter<ProductPresentation, ProductListViewHolder>(ProductDiffChecker()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding: ListItemProductBinding =
            ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductListViewHolder(binding, viewProductDetails)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductDiffChecker : DiffUtil.ItemCallback<ProductPresentation>() {
        override fun areItemsTheSame(
            oldItem: ProductPresentation,
            newItem: ProductPresentation,
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductPresentation,
            newItem: ProductPresentation,
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

open class ProductListViewHolder(
    private val binding: ListItemProductBinding,
    private val viewProductDetails: (ProductPresentation) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductPresentation) {
        with(binding) {
            root.setOnClickListener {
                viewProductDetails(product)
            }
            userIdTv.text = product.id.toString()
            descriptionTv.text = product.description
            Glide.with(binding.root.context).load(product.thumbNailUrl).into(thumbNailImg)
        }
    }

}