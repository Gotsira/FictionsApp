package com.example.got.fictions.models

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