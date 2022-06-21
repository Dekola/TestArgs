package com.dekola.dekk22.data.mapper

import com.dekola.dekk22.data.model.ProductDTO
import com.dekola.dekk22.data.model.ProductPresentation


fun ProductDTO.toPresentation() = ProductPresentation(
    id = id,
    description = description,
    address = address,
    priceAmount = priceAmount,
    nationalShippingCost = nationalShippingCost,
    internationalShippingCost = internationalShippingCost,
    priceCurrency = priceCurrency,
    quantity = quantity,
    thumbNailUrl = picturesData?.firstOrNull()?.formats?.p2?.url,
    imageUrlList = picturesData?.map { it?.formats?.p8?.url }
)