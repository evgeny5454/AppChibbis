package com.evgeny_minaenkov.chibbis.data.model.restaurats

data class RestaurantsResponseItem(
    val DeliveryCost: Int,
    val DeliveryTime: Int,
    val Logo: String,
    val MinCost: Int,
    val Name: String,
    val PositiveReviews: Int,
    val ReviewsCount: Int,
    val Specializations: List<Specialization>
)