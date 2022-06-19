package com.evgeny_minaenkov.chibbis.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://front-task.chibbistest.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}