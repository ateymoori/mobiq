package com.mobiquity.utils.bases

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mobiquity.R
import javax.inject.Inject

class ImageLoader @Inject constructor(
    private val context: Context
) {

    fun load(preLoadUrl: String? = null, url: String?, imageView: ImageView?) {
        if (url != null && imageView != null) {
            Glide.with(context).load(
                url
            ).placeholder(
               R.drawable.placeholder
            )
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }
    }

    fun load(img: Int?, imageView: ImageView?) {
        if (img != null && imageView != null) {
            Glide.with(context).load(img).placeholder(
                R.drawable.placeholder
            ).into(imageView)
        }
    }

}