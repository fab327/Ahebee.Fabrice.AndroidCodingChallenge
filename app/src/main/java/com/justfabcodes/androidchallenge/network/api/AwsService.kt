package com.justfabcodes.androidchallenge.network.api

import com.justfabcodes.androidchallenge.model.Book
import retrofit2.http.GET

interface AwsService {

    @GET("/books.json")
    suspend fun retrieveBooks(): List<Book>

}