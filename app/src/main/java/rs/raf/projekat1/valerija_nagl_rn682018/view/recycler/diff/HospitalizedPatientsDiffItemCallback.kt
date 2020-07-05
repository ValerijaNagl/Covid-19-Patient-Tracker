package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient

class HospitalizedPatientsDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    //proverava da li su dva itema ista
    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    //kada su dva itema ista ( imaju isti id), ali se proverava da li se neka od polja nisu promenili
    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.pic== newItem.pic &&
                oldItem.name == newItem.name &&
                oldItem.lastname == newItem.lastname &&
                oldItem.stanjePriPrijemu == newItem.stanjePriPrijemu &&
                oldItem.trenutnoStanje == newItem.trenutnoStanje &&
                oldItem.primljen == newItem.primljen &&
                oldItem.otpusten == newItem.otpusten
    }

}