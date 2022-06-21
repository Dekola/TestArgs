package com.dekola.dekk22.data.mapper

import com.dekola.dekk22.data.model.ProductEntity
import com.dekola.dekk22.data.model.ProductPresentation

fun ProductPresentation.toEntity() = ProductEntity(
    id = id,
    description = description,
    address = address,
    priceAmount = priceAmount,
    nationalShippingCost = nationalShippingCost,
    internationalShippingCost = internationalShippingCost,
    priceCurrency = priceCurrency,
    quantity = quantity,
    thumbNailUrl = thumbNailUrl,
    imageUrlList = imageUrlList
)
