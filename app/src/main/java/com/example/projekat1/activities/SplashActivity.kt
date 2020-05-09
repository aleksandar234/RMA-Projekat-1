package com.example.projekat1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.User

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPreferences =getSharedPreferences("packageName", Context.MODE_PRIVATE)
        var isLogged = true

        val ime = sharedPreferences.getString("ime",null)
        val prezime = sharedPreferences.getString("prezime",null)
        val bolnica = sharedPreferences.getString("bolnica",null)


        if(ime == null || prezime == null || bolnica == null){
            isLogged = false
        }

        val user = User(ime,prezime,bolnica)

        lateinit var intent : Intent

        if(isLogged){
            intent = Intent(this,MainScreenActivity::class.java)
            intent.putExtra(Konstants.USER,user)

        }else{
            intent = Intent(this,LogInScreenActivity::class.java)
        }
        startActivity(intent)
        finish()

    }

}