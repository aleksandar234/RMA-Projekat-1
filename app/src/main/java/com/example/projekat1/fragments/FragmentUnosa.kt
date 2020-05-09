package com.example.projekat1.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projekat1.R
import com.example.projekat1.model.Pacijent
import com.example.projekat1.view.viewModel.PacijentViewModel
import kotlinx.android.synthetic.main.fragment_unosa.*
import java.text.SimpleDateFormat
import java.util.*

class FragmentUnosa : Fragment(R.layout.fragment_unosa){

    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){

        dodajUCekaonu.setOnClickListener {
            val imeU = unetiImeEt.text.toString()
            val prezimeU = unetiPrezimeEt.text.toString()
            val simptomU = unetiSimptome.text.toString()
            if(imeU.isNullOrBlank() || prezimeU.isNullOrBlank() || simptomU.isNullOrBlank()){
                Toast.makeText(context,"Nisu popunjena sva gore navedena polja",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val rand : Int = (10..100).random()
                val sdf = SimpleDateFormat("M.dd.yyyy")
                val currentDate = sdf.format(Date())
                val patient = Pacijent(
                    imeU,
                    prezimeU,
                    simptomU,
                    simptomU,
                    rand,
                    "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                    currentDate.toString()
                )
                pacijentViewModel.addPacijent(patient)
                Toast.makeText(context,"Uspesno dodat pacijent",Toast.LENGTH_SHORT).show()
                unetiImeEt.text.clear()
                unetiPrezimeEt.text.clear()
                unetiSimptome.text.clear()
            }
        }

    }
}