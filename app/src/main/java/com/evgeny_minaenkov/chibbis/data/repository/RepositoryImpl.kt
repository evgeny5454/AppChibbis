package com.evgeny_minaenkov.chibbis.data.repository

import android.util.Log
import com.evgeny_minaenkov.chibbis.data.model.hits.HitsResponse
import com.evgeny_minaenkov.chibbis.data.model.restaurats.RestaurantsResponse
import com.evgeny_minaenkov.chibbis.data.model.reviews.ReviewsResponse
import com.evgeny_minaenkov.chibbis.data.retrofit.Api

class RepositoryImpl {
    suspend fun getRestaurants(): RestaurantsResponse? {
        return Api.api.getRestaurants().body()
    }

    suspend fun getHits(): HitsResponse? {
        return Api.api.getHits().body()
    }

    suspend fun getReviews(): ReviewsResponse? {
        return Api.api.getReviews().body()
    }
}