package com.example.projekat1.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projekat1.R
import com.example.projekat1.activities.IzmenaActivity
import com.example.projekat1.activities.LogInScreenActivity
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.Pacijent
import com.example.projekat1.model.User
import kotlinx.android.synthetic.main.fragment_profila.*
import timber.log.Timber

class FragmentProfila : Fragment(R.layout.fragment_profila){

    private lateinit var user : User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = activity?.intent?.getParcelableExtra(Konstants.USER) as User
        imePacijenta.text = user.ime
        prezimePacijenta.text = user.prezime
        imeBolnice.text = user.bolnica


        btnOdjavi.setOnClickListener {
            val editor = activity?.getSharedPreferences("packageName",Context.MODE_PRIVATE)?.edit()
            editor?.clear()?.apply()
            startActivity(Intent(activity, LogInScreenActivity::class.java))
            activity?.finish()
        }

        btnIzmeni.setOnClickListener {
            val intent = Intent(activity,IzmenaActivity::class.java)
            intent.putExtra(Konstants.USER,user)
            startActivityForResult(intent,60)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 60 && resultCode == 80){
            user = data?.getParcelableExtra(Konstants.USER) as User
            imePacijenta.text = user.ime
            prezimePacijenta.text = user.prezime
            imeBolnice.text = user.bolnica
        }
    }

}