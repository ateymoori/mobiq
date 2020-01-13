package com.mobiquity.utils.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SalePriceModel(
    val amount: String?,
    val currency: String?
): Parcelable