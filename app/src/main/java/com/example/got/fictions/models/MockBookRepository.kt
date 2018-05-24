package com.example.got.fictions.models

import android.os.AsyncTask
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader
import java.net.URL

class MockBookRepository: BookRepository() {

    override fun loadAllBooks() {
        bookList.clear()
        val task = BookLoaderTask()
        task.execute()
    }

    private inner class BookLoaderTask : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            val result = URL("https://raw.githubusercontent.com/Gotsira/FictionsApp/master/books.json").readText()
            if (result != null) {
                val klaxon = Klaxon()
                JsonReader(StringReader(result)).use { reader ->
                    reader.beginArray {
                        while (reader.hasNext()) {
                            klaxon.parse<Book>(reader)?.let { bookList.add(it) }
                        }
                    }
                }
            }
            return "FINISHED"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            setChanged()
            notifyObservers()
        }

    }
}