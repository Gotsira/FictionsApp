package com.example.got.fictions.models

import java.util.*
import kotlin.collections.ArrayList

abstract class BookRepository: Observable() {

    val bookList = ArrayList<Book>()

    abstract fun loadAllBooks()

    fun getBooks(): ArrayList<Book> {
        return bookList
    }

    fun filterSorted(searchMsg: String): List<Book> {
        var searchBook =  bookList.filter { book: Book ->
            book.title.contains(searchMsg, true)
        }
        return searchBook
    }

}