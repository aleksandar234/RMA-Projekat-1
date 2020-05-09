package com.example.projekat1.view.recycler.viewHolder

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projekat1.activities.KartonActivity
import com.example.projekat1.activities.LogInScreenActivity
import com.example.projekat1.model.Pacijent
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_pacijent_list_item_cekaonica.view.*
import kotlinx.android.synthetic.main.layout_pacijent_list_item_cekaonica.view.imeTv
import kotlinx.android.synthetic.main.layout_pacijent_list_item_cekaonica.view.pacijentIv
import kotlinx.android.synthetic.main.layout_pacijent_list_item_cekaonica.view.prezimeTv
import kotlinx.android.synthetic.main.layout_pacijent_list_item_hospitalizacija.view.*

class PacijentHospitalizacijaViewHolder(override val containerView: View,onOtpustClick : (Int) -> Unit,onKartonClick : (Int) -> Unit) : RecyclerView.ViewHolder(containerView) , LayoutContainer{

    private val dugmeOtpust = containerView.btnOtpust
    private val dugmeKarton = containerView.btnKarton

    init {
        dugmeOtpust.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION){
                onOtpustClick.invoke(adapterPosition)
            }
        }
        dugmeKarton.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION){
                onKartonClick.invoke(adapterPosition)
            }
        }
    }

    fun bind(pacijent: Pacijent){
        val slikaPacijenta = containerView.pacijentIv
        val imePacijenta = containerView.imeTv
        val prezimePacijenta = containerView.prezimeTv
        if(pacijent.slika.isNotEmpty()){
            Picasso
                .get()
                .load(pacijent.slika)
                .into(slikaPacijenta)
        }
        imePacijenta.text = pacijent.ime
        prezimePacijenta.text = pacijent.prezime
    }

}