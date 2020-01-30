package com.justfabcodes.androidchallenge.network

import com.justfabcodes.androidchallenge.model.Book
import com.justfabcodes.androidchallenge.network.api.Service

class GetBooksCommand {

    suspend fun getBooks(): List<Book> {
        return Service.awsService.retrieveBooks()
    }

}