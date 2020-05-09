package com.example.projekat1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekat1.R
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.Pacijent
import com.example.projekat1.model.User
import kotlinx.android.synthetic.main.activity_karton_pacijenta.*
import kotlinx.android.synthetic.main.layout_pacijent_list_item_hospitalizacija.*

class KartonActivity : AppCompatActivity(R.layout.activity_karton_pacijenta){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val patient = intent.getParcelableExtra("patient") as Pacijent
        imeEt.setText(patient.ime)
        prezimeEt.setText(patient.prezime)
        stanjePriPrijemu.setText(patient.simptomiBolestiPriPrijemu)
        trenutnoStanje.setText(patient.simptomiBolestiTrenutno)
        datumPrijema.setText(patient.datum)
        initListeners(patient)
    }

    private fun initListeners(pacijent: Pacijent) {
        btnOdustani.setOnClickListener {
            finish()
        }

        btnIzmeni.setOnClickListener {
            var ime = imeEt.text.toString()
            var prezime = prezimeEt.text.toString()
            var pocetnoStanje = stanjePriPrijemu.text.toString()
            var trenutnoStanje = trenutnoStanje.text.toString()

            if(ime.isNullOrEmpty() || prezime.isNullOrEmpty() || pocetnoStanje.isNullOrEmpty() || trenutnoStanje.isNullOrEmpty()){
                Toast.makeText(this,"Morate popuniti sva polja", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent()
            pacijent.ime = ime
            pacijent.prezime = prezime
            pacijent.simptomiBolestiPriPrijemu = pocetnoStanje
            pacijent.simptomiBolestiTrenutno = trenutnoStanje
            intent.putExtra("patient", pacijent)
            setResult(99,intent)

            finish()
        }
    }

}
