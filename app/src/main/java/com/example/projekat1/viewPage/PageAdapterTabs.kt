package com.example.projekat1.viewPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.projekat1.fragments.FragmentListaCekaonica
import com.example.projekat1.fragments.FragmentListaHospitalizovani
import com.example.projekat1.fragments.FragmentListaOtpusteni

class PageAdapterTabs(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){


    companion object {
        private const val TAB_COUNT = 3
        const val TAB_CEKAONICA = 0
        const val TAB_HOSPITALIZAJICA = 1
        const val TAB_OTPUSTENI = 2
    }
                                /*  Ovde cu da napravim fragmente za skvaki od ovih tabova u kojoj ce da mi bude lista svakog taba
                                 i onda cu u FragmentListe da obrisem sve do initTabs i postavicu viewPager da mi lista ove tabove
                                 koje sam napravio u kojima se nalazi lista pacijenata i izgled karte za svakog od tih pacijenata*/

    override fun getItem(position: Int): Fragment {
        return when(position) {
            TAB_CEKAONICA -> FragmentListaCekaonica()
            TAB_HOSPITALIZAJICA -> FragmentListaHospitalizovani()
            else -> FragmentListaOtpusteni()
        }
    }

    override fun getCount(): Int {
        return TAB_COUNT
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            TAB_CEKAONICA -> "Cekaonica"
            TAB_HOSPITALIZAJICA -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }

}