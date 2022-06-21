package com.dekola.dekk22.data.model

import java.io.Serializable

data class ProductPresentation(
    val id: Int?,
    val description: String?,
    val address: String?,
    val priceAmount: Double?,
    val nationalShippingCost: String?,
    val internationalShippingCost: String?,
    val priceCurrency: String?,
    val quantity: Int?,
    val thumbNailUrl: String?,
    val imageUrlList: List<String?>?,
) : Serializable
