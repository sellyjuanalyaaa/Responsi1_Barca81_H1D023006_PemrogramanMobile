package com.barca.responsi1mobile.data.network

import com.barca.responsi1mobileh1d023006.data.network.FootballApi
import com.barca.responsi1mobileh1d023006.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: FootballApi by lazy {
        retrofit.create(FootballApi::class.java)
    }
}
