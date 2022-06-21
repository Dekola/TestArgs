package com.dekola.dekk22.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dekola.dekk22.PRODUCT_TABLE

@Entity(tableName = PRODUCT_TABLE)
data class ProductEntity(
    @ColumnInfo(name = "Id")
    @PrimaryKey
    val id: Int?,
    var description: String?,
    var address: String?,
    var priceAmount: Double?,
    var priceCurrency: String?,
    var quantity: Int?,
    var internationalShippingCost: String?,
    var nationalShippingCost: String?,
    var thumbNailUrl: String?,
    var imageUrlList: List<String?>?,
)