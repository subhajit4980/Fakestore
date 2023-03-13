package com.example.retrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.View.MainActivity
import com.example.retrofit.model.ProductsItem
import com.google.android.material.imageview.ShapeableImageView

class ProductAdapter( val context:Context):ListAdapter <ProductsItem,ProductAdapter.ProductViewHolder>(DiffUtils()) {
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val  title:TextView=view.findViewById(R.id.title)
        val  category:TextView=view.findViewById(R.id.cat)
        val  price:TextView=view.findViewById(R.id.price)
        val image: ShapeableImageView=view.findViewById(R.id.item_view)
        fun binds(item:ProductsItem,context: Context)
        {
            title.text = item.title
            category.text = item.category
            price.text = item.price.toString()
            Glide.with(context).load(item.image).into(image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProductViewHolder(view)
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.binds(item,context)
    }

    class DiffUtils : DiffUtil.ItemCallback<ProductsItem>() {
        override fun areItemsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem == newItem
        }
    }
}