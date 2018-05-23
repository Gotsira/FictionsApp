package com.example.got.fictions.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.content.Intent
import com.example.got.fictions.R
import com.example.got.fictions.models.Book
import com.example.got.fictions.BookDetails
import kotlinx.android.synthetic.main.book_entry.view.*

class BookAdapter : BaseAdapter {
    var booksList = ArrayList<Book>()
    var context: Context? = null

    constructor(context: Context, booksList: ArrayList<Book>) : super() {
        this.context = context
        this.booksList = booksList
    }

    override fun getCount(): Int {
        return booksList.size
    }

    override fun getItem(position: Int): Any {
        return booksList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val book = this.booksList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var bookView = inflator.inflate(R.layout.book_entry, null)
        bookView.imgBook.setOnClickListener {

            val intent = Intent(context, BookDetails::class.java)
            intent.putExtra("name", book.name!!)
            intent.putExtra("description", book.description!!)
            intent.putExtra("image", book.image!!)
            context!!.startActivity(intent)
        }
        bookView.imgBook.setImageResource(book.image!!)
        bookView.bookName.text = book.name!!

        return bookView
    }
}