package com.mobiquity.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.R
import com.mobiquity.utils.bases.ImageLoader
import com.mobiquity.utils.entities.BannerModel
import com.mobiquity.utils.entities.ProductModel
import kotlinx.android.synthetic.main.products_list_item.view.*
import javax.inject.Inject

class BannersAdapter @Inject constructor() :
    RecyclerView.Adapter<BannersAdapter.Holder>() {

    private lateinit var ctx: Context


    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        ctx = parent.context
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.banners_item,
                parent,
                false
            )
        )
    }

    var items = listOf<BannerModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface OnItemClick {
        fun onItemClick(item: ProductModel)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        imageLoader.load(
            img = item.banner,
            imageView = holder.img
        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.img
    }

}