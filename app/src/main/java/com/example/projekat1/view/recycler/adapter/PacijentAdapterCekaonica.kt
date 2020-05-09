package com.example.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.projekat1.R
import com.example.projekat1.model.Pacijent
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.recycler.viewHolder.PacijentCekaonicaViewHolder


class PacijentAdapterCekaonica (pacijentDiffItemCallback: PacijentDiffItemCallback,private val onPacijentClick : (Pacijent) -> Unit,private val onHospitalizeClick : (Pacijent) -> Unit): ListAdapter<Pacijent,PacijentCekaonicaViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentCekaonicaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_pacijent_list_item_cekaonica,parent,false)
        return PacijentCekaonicaViewHolder(containerView,{
            val pacijent = getItem(it)
            onPacijentClick.invoke(pacijent)
        },{
            val pacijent = getItem(it)
            onHospitalizeClick.invoke(pacijent)
        })
    }



    override fun onBindViewHolder(holder: PacijentCekaonicaViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }

}