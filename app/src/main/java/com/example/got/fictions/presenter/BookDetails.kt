package com.example.got.fictions.presenter

import com.example.got.fictions.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val bundle = intent.extras

        imgBookDetails.setImageResource(bundle.getInt("image"))
        bookName.text = bundle.getString("name")
        bookDetails.text = bundle.getString("description")
    }
}