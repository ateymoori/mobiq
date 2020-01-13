package com.mobiquity.utils.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.R
import com.mobiquity.utils.bases.Constants
import com.mobiquity.utils.bases.ImageLoader
import com.mobiquity.utils.entities.ProductModel
import com.mobiquity.utils.bases.listen
import kotlinx.android.synthetic.main.products_list_item.view.*
import javax.inject.Inject

class ResultsAdapter @Inject constructor() :
    RecyclerView.Adapter<ResultsAdapter.Holder>() {

    private lateinit var ctx: Context

    lateinit var itemClick: OnItemClick

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        ctx = parent.context
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.products_list_item,
                parent,
                false
            )
        ).listen { pos, _ ->
            items[pos].let { itemClick.onItemClick(it) }
        }
    }

    var items = listOf<ProductModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface OnItemClick {
        fun onItemClick(item: ProductModel)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.title.text = item.name
        imageLoader.load(
            url = "${Constants.IMAGES_URL_PREFIX}${item.url}",
            imageView = holder.img
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.title
        val img: ImageView = view.img
    }

}