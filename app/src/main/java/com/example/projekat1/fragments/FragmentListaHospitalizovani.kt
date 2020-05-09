package com.example.projekat1.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekat1.R
import com.example.projekat1.activities.KartonActivity
import com.example.projekat1.activities.LogInScreenActivity
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.Pacijent
import com.example.projekat1.model.SpacingDecorations
import com.example.projekat1.view.recycler.adapter.PacijentAdapterHospitalizacija
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.viewModel.PacijentViewModel
import kotlinx.android.synthetic.main.activity_karton_pacijenta.*
import kotlinx.android.synthetic.main.fragment_liste_cekaonica.pretraga
import kotlinx.android.synthetic.main.fragment_liste_hospitalizacija.*
import timber.log.Timber

class FragmentListaHospitalizovani : Fragment(R.layout.fragment_liste_hospitalizacija) {

    private lateinit var pacijentAdapter : PacijentAdapterHospitalizacija
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
            pacijentViewModel.filterPacijentHospitalizovani(it.toString())
        }
    }

    private fun initRecycle() {
        listRvHospitalizacija.layoutManager = LinearLayoutManager(context)
        pacijentAdapter = PacijentAdapterHospitalizacija(PacijentDiffItemCallback(),{
            pacijentViewModel.dodajUOtpust(it)
        },{
            var intent = Intent(activity,KartonActivity::class.java)
            intent.putExtra("patient",it)
            startActivityForResult(intent,50)
        })
        val spacingDecorations = SpacingDecorations(20)
        listRvHospitalizacija.addItemDecoration(spacingDecorations)
        listRvHospitalizacija.adapter = pacijentAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 50 && resultCode == 99){
            val patient = data?.getParcelableExtra("patient") as Pacijent
            pacijentViewModel.updateKarton(patient)
        }
    }

    private fun initObserver() {
        pacijentViewModel.getPacijenteHospitalizacije().observe(viewLifecycleOwner, Observer {
            pacijentAdapter.submitList(it)
        })
    }
}