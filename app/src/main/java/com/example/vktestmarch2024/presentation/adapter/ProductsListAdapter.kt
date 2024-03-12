package com.example.vktestmarch2024.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.vktestmarch2024.R
import com.example.vktestmarch2024.data.model.ProductSample

class ProductsListAdapter(
    diffCallback: DiffUtil.ItemCallback<ProductSample>
) : PagingDataAdapter<ProductSample, ProductsListViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductsListViewHolder(inflater.inflate(R.layout.item_product_list, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.product_image)
    private val title: TextView = itemView.findViewById(R.id.product_title)
    private val description: TextView = itemView.findViewById(R.id.product_description)

    fun bind(product: ProductSample?) {
        product?.let {
            title.text = it.title
            description.text = it.description
            image.load(it.thumbnail) {
                crossfade(true)
                error(R.drawable.image_broken_24)
                fallback(R.drawable.image_broken_24)
                placeholder(R.drawable.image_placeholder_24)
                scale(Scale.FIT)
            }
        }
    }
}