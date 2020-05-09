package com.example.projekat1.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projekat1.R
import com.example.projekat1.viewPage.PageAdapterTabs
import kotlinx.android.synthetic.main.fragment_liste.*
import kotlinx.android.synthetic.main.fragment_liste.viewPager

class FragmentListe : Fragment(R.layout.fragment_liste){

//    private lateinit var pacijentAdapter : PacijentAdapter
//    private val pacijentViewModel : PacijentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
//        initObservers()
    }

    private fun initUi() {
        initTabs()
//        initListeners()
//        initRecycler()
    }

    private fun initTabs() {
        viewPager.adapter = PageAdapterTabs(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

//    private fun initListeners() {
//        pretraga.doAfterTextChanged {
//            pacijentViewModel.filterPacijent(it.toString())
//        }
//    }
//
//    private fun initRecycler() {
//        listRv.layoutManager = LinearLayoutManager(context)
//        pacijentAdapter = PacijentAdapter(PacijentDiffItemCallback())
//        val spacingDecorations = SpacingDecorations(20)
//        listRv.addItemDecoration(spacingDecorations)
//        listRv.adapter = pacijentAdapter
//    }
//
//    private fun initObservers() {
//        pacijentViewModel.getPacijente().observe(viewLifecycleOwner, Observer {
//            pacijentAdapter.submitList(it)
//        })
//    }

}