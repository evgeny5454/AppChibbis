package com.evgeny_minaenkov.chibbis.data.retrofit

import com.evgeny_minaenkov.chibbis.data.model.hits.HitsResponse
import com.evgeny_minaenkov.chibbis.data.model.restaurats.RestaurantsResponse
import com.evgeny_minaenkov.chibbis.data.model.reviews.ReviewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/restaurants")
    suspend fun getRestaurants(): Response<RestaurantsResponse>

    @GET("api/v1/reviews")
    suspend fun getReviews(): Response<ReviewsResponse>

    @GET("api/v1/hits")
    suspend fun getHits(): Response<HitsResponse>

}