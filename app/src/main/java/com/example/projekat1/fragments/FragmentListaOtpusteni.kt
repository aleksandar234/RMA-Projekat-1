package com.example.projekat1.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekat1.R
import com.example.projekat1.model.SpacingDecorations
import com.example.projekat1.view.recycler.adapter.PacijentAdapterOtpusten
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.viewModel.PacijentViewModel
import kotlinx.android.synthetic.main.fragment_liste_otpusteni.*

class FragmentListaOtpusteni : Fragment(R.layout.fragment_liste_otpusteni) {


    private lateinit var pacijentAdapter : PacijentAdapterOtpusten
    private val pacijentViewModel : PacijentViewModel by activityViewModels()
    private lateinit var gridLayoutManager: GridLayoutManager

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
        pretragaOtpusteni.doAfterTextChanged {
            pacijentViewModel.filterPacijentOtpusteni(it.toString())
        }
    }

    private fun initRecycle() {
        listRvOtpusteni.layoutManager = GridLayoutManager(context,2)
        pacijentAdapter = PacijentAdapterOtpusten(PacijentDiffItemCallback())
        val spacingDecorations = SpacingDecorations(20)
        listRvOtpusteni.addItemDecoration(spacingDecorations)
        listRvOtpusteni.adapter = pacijentAdapter
    }

    private fun initObserver() {
        pacijentViewModel.getPacijenteOtpustene().observe(viewLifecycleOwner, Observer {
            pacijentAdapter.submitList(it)
        })
    }


}