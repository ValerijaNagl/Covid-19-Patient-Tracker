package com.example.vezbe6.valerija_nagl_rn682018.application.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.view.viewpager.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()

    }

    private fun initViewPager() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.stanje ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false)
                }
                R.id.unos->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_2, false)
                }
                R.id.liste->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_3, false)
                }
                R.id.profil->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_4, false)
                }
            }
            true
        }
    }
}
