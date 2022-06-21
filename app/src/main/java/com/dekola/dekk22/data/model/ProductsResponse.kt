package com.dekola.dekk22.data.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("objects")
	val objects: List<ProductDTO?>? = null
)

data class UserData(

	@field:SerializedName("id")
	val id: Int? = null
)

data class Formats(

	@field:SerializedName("P1")
	val p1: P1? = null,

	@field:SerializedName("P2")
	val p2: P2? = null,

	@field:SerializedName("P4")
	val p4: P4? = null,

	@field:SerializedName("P5")
	val p5: P5? = null,

	@field:SerializedName("P6")
	val p6: P6? = null,

	@field:SerializedName("P7")
	val p7: P7? = null,

	@field:SerializedName("P8")
	val p8: P8? = null
)

data class P1(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class P2(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Variants(

	@field:SerializedName("17")
	val jsonMember17: Int? = null,

	@field:SerializedName("4")
	val jsonMember4: Int? = null,

	@field:SerializedName("12")
	val jsonMember12: Int? = null,

	@field:SerializedName("3")
	val jsonMember3: Int? = null,

	@field:SerializedName("5")
	val jsonMember5: Int? = null
)

data class ProductDTO(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("pictures_data")
	val picturesData: List<PicturesDataItem?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("price_amount")
	val priceAmount: Double? = null,

	@field:SerializedName("variants")
	val variants: Variants? = null,

	@field:SerializedName("user_data")
	val userData: UserData? = null,

	@field:SerializedName("national_shipping_cost")
	val nationalShippingCost: String? = null,

	@field:SerializedName("pub_date")
	val pubDate: String? = null,

	@field:SerializedName("active_status")
	val activeStatus: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("international_shipping_cost")
	val internationalShippingCost: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("categories")
	val categories: List<Int?>? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("variant_set")
	val variantSet: Int? = null,

	@field:SerializedName("hand_delivery")
	val handDelivery: Boolean? = null,

	@field:SerializedName("price_currency")
	val priceCurrency: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("purchase_via_paypal")
	val purchaseViaPaypal: Boolean? = null,

	@field:SerializedName("brand_id")
	val brandId: Int? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null
)

data class Meta(

	@field:SerializedName("last_offset_id")
	val lastOffsetId: String? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("end")
	val end: Boolean? = null
)

data class P5(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class P4(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class P8(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class P6(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class PicturesDataItem(

	@field:SerializedName("formats")
	val formats: Formats? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class P7(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
