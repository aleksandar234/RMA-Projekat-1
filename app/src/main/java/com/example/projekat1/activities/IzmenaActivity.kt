package com.example.projekat1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekat1.R
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.User
import kotlinx.android.synthetic.main.activity_izmena.*

class IzmenaActivity : AppCompatActivity(R.layout.activity_izmena) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var user : User = this.intent.getParcelableExtra(Konstants.USER) as User
        imeEt.setText(user.ime.toString())
        prezimeEt.setText(user.prezime.toString())
        bolnicaEt.setText(user.bolnica.toString())


        btnOdustani.setOnClickListener {
//            val intent = Intent(this,MainScreenActivity::class.java)
//            intent.putExtra("Profil","Activity4")
//            intent.putExtra(Konstants.USER,user)
//            startActivity(intent)
            finish()
        }

        btnIzmeni.setOnClickListener {
            var ime = imeEt.text.toString()
            var prezime = prezimeEt.text.toString()
            var bolnica = bolnicaEt.text.toString()

            if(ime.isNullOrEmpty()){
                Toast.makeText(this,"Niste popunili polje za Ime",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (prezime.isNullOrEmpty()){
                Toast.makeText(this,"Niste popunili polje za Prezime",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (bolnica.isNullOrEmpty()){
                Toast.makeText(this,"Niste popunili polje za Bolnicu",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val editor = getSharedPreferences("packageName", Context.MODE_PRIVATE).edit()
            editor.putString("ime",ime)
            editor.putString("prezime",prezime)
            editor.putString("bolnica",bolnica)
            editor.commit()

            val intent = Intent()
            user.ime = ime
            user.prezime = prezime
            user.bolnica = bolnica
            intent.putExtra(Konstants.USER, user)
            setResult(80,intent)

            finish()

        }

    }

}