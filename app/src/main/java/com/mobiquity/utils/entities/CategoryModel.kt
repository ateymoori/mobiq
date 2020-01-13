package com.mobiquity.utils.entities

data class CategoryModel(
    val description: String,
    val id: String,
    val name: String,
    val products: List<ProductModel>
)