package com.example.projekat1.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.projekat1.model.Pacijent
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_pacijent_list_item_cekaonica.view.*

class PacijentCekaonicaViewHolder(override val containerView: View, onPacijentClick : (Int) -> Unit, onHospitolizeClick : (Int) -> Unit) : RecyclerView.ViewHolder(containerView) , LayoutContainer{


    private val dugmeZdrav = containerView.btnZdrav
    private val dugmeHospitalizovan = containerView.btnHospitalizacija



    init {
        dugmeZdrav.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION){
                onPacijentClick.invoke(adapterPosition)
            }
        }
        dugmeHospitalizovan.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION){
                onHospitolizeClick.invoke(adapterPosition)
            }
        }
    }

    fun bind(pacijent: Pacijent){
        val slikaPacijenta = containerView.pacijentIv
        val imePacijenta = containerView.imeTv
        val prezimePacijenta = containerView.prezimeTv
        val simptomPacijenta = containerView.simptomi
        if(pacijent.slika.isNotEmpty()){
            Picasso
                .get()
                .load(pacijent.slika)
                .into(slikaPacijenta)
        }
        imePacijenta.text = pacijent.ime
        prezimePacijenta.text = pacijent.prezime
        simptomPacijenta.text = pacijent.simptomiBolestiPriPrijemu
    }

}