package com.example.got.fictions.presenter

import com.example.got.fictions.models.Book

interface BookView {
    fun setBookList(books: ArrayList<Book>)
}