package com.example.got.fictions.models

import kotlinx.android.synthetic.main.book_entry.view.*

class Book {
    var name: String? = null
    var description: String? = null
    var image: Int? = null

    constructor(name: String, description: String, image: Int) {
        this.name = name
        this.description = description
        this.image = image
    }
}