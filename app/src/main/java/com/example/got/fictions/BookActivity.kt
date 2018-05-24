package com.example.got.fictions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.got.fictions.fragment.BookListFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var bookListFragment: BookListFragment
    private var mSectionsPagerAdapter: ShowAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookListFragment = BookListFragment()

        mSectionsPagerAdapter = ShowAdapter(supportFragmentManager)

        container.adapter = mSectionsPagerAdapter


    }

    inner class ShowAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return bookListFragment
        }

        override fun getCount(): Int {
            return 1
        }
    }

}
