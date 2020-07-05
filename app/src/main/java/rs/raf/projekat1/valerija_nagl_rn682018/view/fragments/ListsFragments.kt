package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.view.viewpager.PagerAdapterTabs
import kotlinx.android.synthetic.main.fragment_tabs.*


class ListsFragments : Fragment(R.layout.fragment_tabs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewPagerTabs.adapter = PagerAdapterTabs(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerTabs)
    }

}
