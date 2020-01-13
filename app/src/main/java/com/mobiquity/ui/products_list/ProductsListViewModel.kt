package com.mobiquity.ui.products_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobiquity.di.repo.MainRepo
import com.mobiquity.utils.bases.BaseViewModel
import com.mobiquity.utils.entities.CategoryModel
import com.mobiquity.utils.entities.CommonResponse
import com.mobiquity.utils.entities.Loading
import com.mobiquity.utils.entities.Success
import javax.inject.Inject
import kotlinx.coroutines.launch


class ProductsListViewModel @Inject constructor(
    private val mainRepo: MainRepo
) :
    BaseViewModel<ProductListContract>() {

    private lateinit var cats: List<String>
    val result = MutableLiveData<CommonResponse<Any?>>()

    lateinit var data: List<CategoryModel>


    override fun onViewCreated() {
        super.onViewCreated()
        navigator?.loadBanners(mainRepo.getBanners())
    }

    //using Coroutine for handle threads
    fun getProducts() {
        viewModelScope.launch {
            //show loading on UI
            result.value = Loading(null)
            //get data
            data = mainRepo.getData()

            //show cats
            cats = data.map { it.name }
            navigator?.onLoadCategories(cats)

            //show results
            onCategorySelect(cats[0])
        }
    }

      fun onCategorySelect(category: String) {
        viewModelScope.launch {
            result.value = Success(data = mainRepo.getProducts(category))
        }
    }

}