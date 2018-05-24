package com.example.got.fictions.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.got.fictions.R
import com.example.got.fictions.adapter.BookAdapter
import com.example.got.fictions.models.Book
import com.example.got.fictions.models.BookRepository
import com.example.got.fictions.models.MockBookRepository
import com.example.got.fictions.presenter.BookPresenter
import com.example.got.fictions.presenter.BookView
import kotlinx.android.synthetic.main.book_fragment.view.*

class BookListFragment : Fragment(), BookView {

    var adapter: BookAdapter? = null
    lateinit var presenter: BookPresenter
    lateinit var repository: BookRepository
    lateinit var rootView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(R.layout.book_fragment, container, false)
        repository = MockBookRepository()
        presenter = BookPresenter(this, repository)
        presenter.start()
        setSearchView()
        return rootView
    }

    override fun setBookList(books: ArrayList<Book>) {
        adapter = BookAdapter(rootView.context, books)
        rootView.gvBooks.adapter = adapter
    }

    private fun setSearchView() {
        rootView.searchBar.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null)
                    presenter.search(rootView.searchBar.query.toString())
                return false
            }
        })
    }

}