package com.example.projekat1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Pacijent(
    var ime : String,
    var prezime : String,
    var simptomiBolestiPriPrijemu : String,
    var simptomiBolestiTrenutno : String,
    var id : Int,
    var slika : String,
    var datum : String
) : Parcelable