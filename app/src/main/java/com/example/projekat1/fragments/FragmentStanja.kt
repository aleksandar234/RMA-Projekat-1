package com.example.projekat1.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.projekat1.R
import com.example.projekat1.view.viewModel.PacijentViewModel
import kotlinx.android.synthetic.main.fragment_stanja.*


class FragmentStanja : Fragment(R.layout.fragment_stanja){

    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        pacijentViewModel.getPacijenteCekaonice().observe(viewLifecycleOwner, Observer {
            stanjeUCekaonici.text = pacijentViewModel.brojCekaonica().toString()
        })
        pacijentViewModel.getPacijenteHospitalizacije().observe(viewLifecycleOwner, Observer {
            stanjeZaHospitalizaciju.text = pacijentViewModel.brojHospitalizacija().toString()
        })
        pacijentViewModel.getPacijenteOtpustene().observe(viewLifecycleOwner, Observer {
            stanjeOtpustenih.text = pacijentViewModel.brojOtpusteni().toString()
        })
    }


}