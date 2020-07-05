package com.example.vezbe6.valerija_nagl_rn682018.application.view.viewpager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.AddPatientFragment
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.ListsFragments
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.OverviewFragment
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.ProfileFragment


class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
        const val FRAGMENT_4 = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> OverviewFragment()
            FRAGMENT_2 -> AddPatientFragment()
            FRAGMENT_3 -> ListsFragments()
            else -> ProfileFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }




}
