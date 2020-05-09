package com.example.projekat1.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.projekat1.model.Pacijent
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_pacijent_list_item_otpusteni.view.*
import java.text.SimpleDateFormat
import java.util.*

class PacijentOtpusteniViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {

    fun bind(pacijent: Pacijent){
        val slikaPacijenta = containerView.pacijentIvOtpusteni
        val imePacijenta = containerView.imeTvOtpusteni
        val prezimePacijenta = containerView.prezimeTvOtpusteni
        val sdf = SimpleDateFormat("M.dd.yyyy")
        val currentDate = sdf.format(Date())
        val otpust = containerView.datumOtpustanja
        if(pacijent.slika.isNotEmpty()){
            Picasso
                .get()
                .load(pacijent.slika)
                .into(slikaPacijenta)
        }
        imePacijenta.text = pacijent.ime
        prezimePacijenta.text = pacijent.prezime
        otpust.text = "Otpusten : " + currentDate.toString()
    }

}