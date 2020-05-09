package com.example.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.projekat1.R
import com.example.projekat1.model.Pacijent
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.recycler.viewHolder.PacijentCekaonicaViewHolder
import com.example.projekat1.view.recycler.viewHolder.PacijentHospitalizacijaViewHolder


class PacijentAdapterHospitalizacija (pacijentDiffItemCallback: PacijentDiffItemCallback,private val onOtpustClick : (Pacijent) -> Unit,private val onKartonClick : (Pacijent) -> Unit): ListAdapter<Pacijent,PacijentHospitalizacijaViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentHospitalizacijaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_pacijent_list_item_hospitalizacija,parent,false)
        return PacijentHospitalizacijaViewHolder(containerView,{
            val pacijent = getItem(it)
            onOtpustClick.invoke(pacijent)
        },{
            val pacijent = getItem(it)
            onKartonClick.invoke(pacijent)
        })
    }

    override fun onBindViewHolder(holder: PacijentHospitalizacijaViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }

}