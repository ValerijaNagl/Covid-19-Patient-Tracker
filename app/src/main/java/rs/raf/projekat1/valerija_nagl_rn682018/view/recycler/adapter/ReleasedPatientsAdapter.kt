package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.ReleasedPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder.ReleasedPatientViewHolder


class ReleasedPatientsAdapter(releasedPatientDiffItemCallback: ReleasedPatientsDiffItemCallback)
    : ListAdapter<Patient, ReleasedPatientViewHolder>(releasedPatientDiffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleasedPatientViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.released_patient_item, parent, false)
        return ReleasedPatientViewHolder(containerView)

    }

    override fun onBindViewHolder(holder: ReleasedPatientViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}