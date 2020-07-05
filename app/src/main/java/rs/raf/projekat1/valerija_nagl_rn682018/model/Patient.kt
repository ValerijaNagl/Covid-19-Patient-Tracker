package com.example.vezbe6.valerija_nagl_rn682018.application.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Patient(val id : Int, var name : String, var lastname:String, var stanjePriPrijemu : String, var trenutnoStanje : String,
                   var primljen : String, var otpusten : String, val pic : String) : Parcelable
