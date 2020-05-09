package com.example.projekat1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.projekat1.R
import com.example.projekat1.fragments.FragmentListe
import com.example.projekat1.viewPage.PageAdapter
import com.example.projekat1.viewPage.PageAdapterTabs
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.activity_main_screen.*
import kotlinx.android.synthetic.main.fragment_liste.*
import timber.log.Timber

class MainScreenActivity : AppCompatActivity(R.layout.activity_main_screen){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewpager()
        initNavigation()
    }

    private fun initViewpager() {
        viewPager1.adapter = PageAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        val act: String? = intent.getStringExtra("Profil")
        Timber.e("Ovo je ono sto sam ti prosledio $act")
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation1 -> {
                    viewPager1.setCurrentItem(PageAdapter.FRAGMENT_STANJE, false)
                }
                R.id.navigation2 -> {
                    viewPager1.setCurrentItem(PageAdapter.FRAGMENT_UNOS, false)
                }
                R.id.navigation3 -> {
                    viewPager1.setCurrentItem(PageAdapter.FRAGMENT_LISTE, false)
                }
                R.id.navigation4 -> {
                    viewPager1.setCurrentItem(PageAdapter.FRAGMENT_PROFIL, false)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
//        if(!act.isNullOrEmpty()){
//            bottomNavigation.selectedItemId = R.id.navigation4
//            viewPager1.setCurrentItem(PageAdapter.FRAGMENT_PROFIL, false)
//        }else{
//            bottomNavigation.selectedItemId = R.id.navigation1
//            viewPager1.setCurrentItem(PageAdapter.FRAGMENT_STANJE, false)
//        }
    }
}