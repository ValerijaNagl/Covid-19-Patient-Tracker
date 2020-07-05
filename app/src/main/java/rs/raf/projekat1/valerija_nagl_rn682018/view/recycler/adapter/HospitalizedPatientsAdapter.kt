package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.HospitalizedPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder.HospitalizedPatientsViewHolder


class HospitalizedPatientsAdapter(hospitalizedPatientsDiffItemCallback: HospitalizedPatientsDiffItemCallback, private val onPatientClicked: (Patient, String) -> Unit)
    : ListAdapter<Patient, HospitalizedPatientsViewHolder>(hospitalizedPatientsDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizedPatientsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.hospitalized_patient_item, parent, false)

        return HospitalizedPatientsViewHolder(containerView){ adapterPosition: Int, btn: String ->

            val patient = getItem(adapterPosition)
            onPatientClicked.invoke(patient, btn)

        }
    }

    override fun onBindViewHolder(holder: HospitalizedPatientsViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}