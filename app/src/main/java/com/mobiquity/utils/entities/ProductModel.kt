package com.mobiquity.utils.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductModel(
    val categoryId: String,
    val description: String,
    val id: String,
    val name: String,
    var url: String?,
    val salePrice: SalePriceModel?
) : Parcelable