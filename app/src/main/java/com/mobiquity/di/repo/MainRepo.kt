package com.mobiquity.di.repo

import com.mobiquity.R
import com.mobiquity.utils.bases.Constants
import com.mobiquity.utils.entities.BannerModel
import com.mobiquity.utils.entities.CategoryModel
import com.mobiquity.utils.entities.ProductModel
import javax.inject.Inject

class MainRepo @Inject
constructor(
    private val repoService: RestService
) {
    private lateinit var data: List<CategoryModel>

    suspend fun getData() =
        repoService.getData().also { data = it }


    suspend fun getProducts(category: String): List<ProductModel> {
        if (!::data.isInitialized)
            data = getData()

        return data.filter { it.name == category }.flatMap {
            it.products
        }
    }


    fun getBanners() =
        listOf(
            BannerModel(R.drawable.fresh),
            BannerModel(R.drawable.fruits),
            BannerModel(R.drawable.spices),
            BannerModel(R.drawable.fishes)
        )
}
