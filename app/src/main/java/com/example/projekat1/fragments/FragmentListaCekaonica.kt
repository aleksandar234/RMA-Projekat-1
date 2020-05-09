package com.example.projekat1.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekat1.R
import com.example.projekat1.model.SpacingDecorations
import com.example.projekat1.view.recycler.adapter.PacijentAdapterCekaonica
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.viewModel.PacijentViewModel
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_liste_cekaonica.*

class FragmentListaCekaonica : Fragment(R.layout.fragment_liste_cekaonica) {

    private lateinit var pacijentAdapter : PacijentAdapterCekaonica
    private val pacijentViewModel : PacijentViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListener()
        initRecycle()
        initObserver()
    }

    private fun initListener() {
        pretraga.doAfterTextChanged {
            pacijentViewModel.filterPacijentCekaonica(it.toString())
        }
    }

    private fun initRecycle() {
        listRvCekaonica.layoutManager = LinearLayoutManager(activity)
        pacijentAdapter = PacijentAdapterCekaonica(PacijentDiffItemCallback(),{
            pacijentViewModel.removePacijent(it)
        },{
            pacijentViewModel.addHospitolize(it)
        })
        val spacingDecorations = SpacingDecorations(20)
        listRvCekaonica.addItemDecoration(spacingDecorations)
        listRvCekaonica.adapter = pacijentAdapter
    }

    private fun initObserver() {
        pacijentViewModel.getPacijenteCekaonice().observe(viewLifecycleOwner, Observer {
            pacijentAdapter.submitList(it)
        })
    }


}