package com.example.projekat1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var ime : String? , var prezime : String? , var bolnica : String?) : Parcelable{
}