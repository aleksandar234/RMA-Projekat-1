package com.example.projekat1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekat1.R
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LogInScreenActivity : AppCompatActivity(R.layout.activity_login){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnPrijava.setOnClickListener {
            var ime = firstName.text.toString()
            var prezime = lastName.text.toString()
            var bolnica = hospitalName.text.toString()
            var pin = pinEt.text.toString()

            if(ime.isNullOrEmpty() || prezime.isNullOrEmpty() || bolnica.isNullOrEmpty()){
                Toast.makeText(this,"Neki od polja je prazno",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pin.isNullOrEmpty()){
                Toast.makeText(this,"Polje za pin je prazno",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(pin.length > 4 || pin.length < 4){
                Toast.makeText(this,"Polje za pin nije odgovarajuce duzine",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(!(pin == Konstants.PIN)){
                Toast.makeText(this,"Uneli ste pogresan pin",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val editor = getSharedPreferences("packageName",Context.MODE_PRIVATE).edit()
                editor.putString("ime",ime)
                editor.putString("prezime",prezime)
                editor.putString("bolnica",bolnica)
                editor.apply()

                val user = User(ime,prezime,bolnica)
                val intent = Intent(this,MainScreenActivity::class.java)
                intent.putExtra(Konstants.USER,user)
                intent.putExtra("ime",ime)
                intent.putExtra("prezime",prezime)
                startActivity(intent)
                finish()
            }


        }

    }

}