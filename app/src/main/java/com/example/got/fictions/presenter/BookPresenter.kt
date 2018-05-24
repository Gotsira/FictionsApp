package com.example.got.fictions.presenter

import com.example.got.fictions.models.Book
import com.example.got.fictions.models.BookRepository
import java.util.*
import kotlin.collections.ArrayList

class BookPresenter(val view: BookView, val repository: BookRepository) : Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBooks()
    }

    override fun update(o: Observable?, arg: Any?) {
       if(o == repository) {
           view.setBookList(repository.getBooks())
       }
    }

    fun search(searchMsg: String) {
        view.setBookList(repository.filterSorted(searchMsg) as ArrayList<Book>)
    }
}