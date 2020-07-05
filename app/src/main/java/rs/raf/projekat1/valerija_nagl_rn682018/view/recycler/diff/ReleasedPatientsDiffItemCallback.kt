package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient



class ReleasedPatientsDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

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