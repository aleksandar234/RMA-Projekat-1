package com.example.projekat1.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.projekat1.model.Pacijent

class PacijentDiffItemCallback : DiffUtil.ItemCallback<Pacijent>(){

    override fun areItemsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.ime == newItem.ime
                && oldItem.prezime == newItem.prezime
                && oldItem.datum == newItem.datum
                && oldItem.simptomiBolestiPriPrijemu == newItem.simptomiBolestiPriPrijemu
                && oldItem.simptomiBolestiTrenutno == newItem.simptomiBolestiTrenutno
    }

}