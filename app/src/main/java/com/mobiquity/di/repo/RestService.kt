package com.mobiquity.di.repo

import com.mobiquity.utils.entities.CategoryModel
import retrofit2.http.*

interface RestService {

    @GET("?")
    suspend fun getData(): List<CategoryModel>

}