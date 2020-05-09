package com.example.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.projekat1.R
import com.example.projekat1.model.Pacijent
import com.example.projekat1.view.recycler.diff.PacijentDiffItemCallback
import com.example.projekat1.view.recycler.viewHolder.PacijentOtpusteniViewHolder

class PacijentAdapterOtpusten (pacijentDiffItemCallback: PacijentDiffItemCallback): ListAdapter<Pacijent, PacijentOtpusteniViewHolder>(pacijentDiffItemCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentOtpusteniViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_pacijent_list_item_otpusteni,parent,false)
        return PacijentOtpusteniViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: PacijentOtpusteniViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }

}
















