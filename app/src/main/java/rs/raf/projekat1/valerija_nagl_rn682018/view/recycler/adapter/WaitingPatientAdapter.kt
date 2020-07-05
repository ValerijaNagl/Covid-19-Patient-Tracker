package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.WaitingPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder.WaitingPatientViewHolder

class WaitingPatientAdapter(waitingPatientDiffItemCallback: WaitingPatientsDiffItemCallback, private val onPatientClicked: (Patient, String) -> Unit)
    : ListAdapter<Patient, WaitingPatientViewHolder>(waitingPatientDiffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingPatientViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.pacijent_u_cekaonici, parent, false)

        return WaitingPatientViewHolder(containerView){ adapterPosition: Int, btn: String ->

            val patient = getItem(adapterPosition)
            onPatientClicked.invoke(patient, btn)
            //            val res = it.split(",")
//            val patient = getItem(Integer.parseInt(res[0]))
//            val patientId = patient.id
//            // saljemo id pacijenta koji je zdrav ili treba da se hospitalizuje kao i flag koji nam govori koje dugme je pritisnuto
//            val out = Integer.toString(patientId) + "," + res[1]
//            onPatientClicked.invoke(out)

        }
    }


    override fun onBindViewHolder(holder: WaitingPatientViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}