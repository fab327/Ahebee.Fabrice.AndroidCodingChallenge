package com.justfabcodes.androidchallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justfabcodes.androidchallenge.model.Book
import com.justfabcodes.androidchallenge.network.GetBooksCommand
import kotlinx.coroutines.*

class MainActivityViewModel: ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val books = MutableLiveData<List<Book>>()
    private val getBooksCommand = GetBooksCommand()

    fun displayBooks(): LiveData<List<Book>> = books

    fun retrieveBooks() {
        viewModelScope.launch {
            books.postValue(getBooksCommand.getBooks())
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}