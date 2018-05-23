package com.example.got.fictions.presenter

import com.example.got.fictions.models.BookRepository
import java.util.*

class BookPresenter(val view: BookView, val repository: BookRepository) : Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBook()
    }

    override fun update(o: Observable?, arg: Any?) {
       if(o == repository) {
           view.setBookList(repository.getBookList())
       }
    }
}