package com.mobiquity.ui.product_detail


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobiquity.R
import com.mobiquity.utils.bases.Constants
import com.mobiquity.utils.bases.Constants.Companion.ITEM_BUNDLE
import com.mobiquity.utils.bases.ExpandedBottomSheetDialog
import com.mobiquity.utils.bases.ImageLoader
import com.mobiquity.utils.entities.ProductModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_product_detail.*
import javax.inject.Inject


class ProductDetailFragment : ExpandedBottomSheetDialog() {

    private lateinit var item: ProductModel

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)

        arguments?.let {
            item = it.getParcelable(ITEM_BUNDLE)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = item.name
        price.text = "${item.salePrice?.currency}  ${item.salePrice?.amount}"
        imageLoader.load(
            url = "${Constants.IMAGES_URL_PREFIX}${item.url}",
            imageView = img
        )

        back.setOnClickListener { dismiss() }
    }

}
