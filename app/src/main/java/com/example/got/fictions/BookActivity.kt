package com.example.got.fictions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.got.fictions.adapter.BookAdapter
import com.example.got.fictions.models.Book
import com.example.got.fictions.models.BookRepository
import com.example.got.fictions.models.MockBookRepository
import com.example.got.fictions.presenter.BookPresenter
import com.example.got.fictions.presenter.BookView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BookView {


    var adapter: BookAdapter? = null
    private lateinit var repository: BookRepository
    private var bookList = ArrayList<Book>()
    private lateinit var presenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = MockBookRepository()
        presenter = BookPresenter(this, repository)
        presenter.start()
    }

    override fun setBookList(books: ArrayList<Book>) {
        adapter = BookAdapter(this, books)
        gvBooks.adapter = adapter
    }
}
