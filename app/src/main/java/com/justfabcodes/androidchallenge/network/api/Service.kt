package com.justfabcodes.androidchallenge.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {

    private const val BASE_URL = "https://de-coding-test.s3.amazonaws.com"

    var awsService: AwsService
        private set

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

        awsService = retrofit.create(AwsService::class.java)
    }

}