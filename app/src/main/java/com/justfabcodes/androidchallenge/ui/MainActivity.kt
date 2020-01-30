package com.justfabcodes.androidchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.justfabcodes.androidchallenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        initView()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.displayBooks().observe(this, Observer {
            mainActivityProgressIndicator.hide()

            (mainActivityRecyclerView.adapter as BooksAdapter).books = it
        })
    }

    private fun initView() {
        mainActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        mainActivityRecyclerView.adapter = BooksAdapter()
        mainActivityRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )

        mainActivityGetBooksButton.setOnClickListener {
            mainActivityProgressIndicator.show()

            viewModel.retrieveBooks()
        }
    }

}
