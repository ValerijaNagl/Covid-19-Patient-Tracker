package com.example.vezbe6.valerija_nagl_rn682018.application.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.RecyclerWaitingRoomFragment
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.RecyclerHospitalizedFragment
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.RecyclerReleasedFragment

class PagerAdapterTabs(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> RecyclerWaitingRoomFragment()
            FRAGMENT_2 -> RecyclerHospitalizedFragment()
            else -> RecyclerReleasedFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

       override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_1 -> "ČEKAONICA"
            FRAGMENT_2 -> "HOSPITALIZOVANI"
            else -> "OTPUŠTENI"
        }
    }


}