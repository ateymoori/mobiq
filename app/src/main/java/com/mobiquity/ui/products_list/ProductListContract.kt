package com.mobiquity.ui.products_list

import com.mobiquity.utils.entities.BannerModel

interface ProductListContract {

    fun loadBanners(banners: List<BannerModel>)
    fun onLoadCategories(categories:List<String>)
}