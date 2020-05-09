package com.example.projekat1.viewPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.projekat1.fragments.FragmentListe
import com.example.projekat1.fragments.FragmentProfila
import com.example.projekat1.fragments.FragmentStanja
import com.example.projekat1.fragments.FragmentUnosa

class PageAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object{
        private const val ITEM_COUNT = 4
        const val FRAGMENT_STANJE = 0
        const val FRAGMENT_UNOS = 1
        const val FRAGMENT_LISTE = 2
        const val FRAGMENT_PROFIL = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_STANJE -> FragmentStanja()
            FRAGMENT_UNOS -> FragmentUnosa()
            FRAGMENT_LISTE -> FragmentListe()
            else -> FragmentProfila()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            FRAGMENT_STANJE -> "Stanje"
            FRAGMENT_UNOS -> "Unos"
            FRAGMENT_LISTE -> "Liste"
            else -> "Profil"
        }
    }

}