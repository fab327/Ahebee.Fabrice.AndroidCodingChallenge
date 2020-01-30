package com.justfabcodes.androidchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfabcodes.androidchallenge.R
import com.justfabcodes.androidchallenge.model.Book
import kotlinx.android.synthetic.main.recycler_view_book_item.view.*

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    var books: List<Book> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_book_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBook(books[position])
    }

    override fun getItemCount(): Int = books.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindBook(book: Book) {
            with(itemView) {
                Glide.with(view)
                    .load(book.imageURL)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(bookItemImageView)
                bookItemTextView.text = book.title
            }
        }

    }

}