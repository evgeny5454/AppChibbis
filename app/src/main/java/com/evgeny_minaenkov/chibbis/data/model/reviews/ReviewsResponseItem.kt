package com.evgeny_minaenkov.chibbis.data.model.reviews

data class ReviewsResponseItem(
    val DateAdded: String,
    val IsPositive: Boolean,
    val Message: String,
    val RestaurantName: String,
    val UserFIO: String
)