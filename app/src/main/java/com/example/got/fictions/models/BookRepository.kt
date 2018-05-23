package com.example.got.fictions.models

import java.util.*
import kotlin.collections.ArrayList

abstract class BookRepository : Observable() {
    abstract fun loadAllBook()

    abstract fun getBookList(): ArrayList<Book>
}