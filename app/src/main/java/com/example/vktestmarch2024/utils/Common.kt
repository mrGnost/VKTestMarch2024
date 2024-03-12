package com.example.vktestmarch2024.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.vktestmarch2024.data.model.ProductSample

object Common {
    object ProductComparator : DiffUtil.ItemCallback<ProductSample>() {
        override fun areItemsTheSame(oldItem: ProductSample, newItem: ProductSample): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductSample, newItem: ProductSample): Boolean {
            return oldItem == newItem
        }
    }
}