package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.released_patient_item.view.*

class ReleasedPatientViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {

    }


    fun bind(pacijent : Patient){
        containerView.name_patientTv.text = pacijent.name
        containerView.lastname_patientTv.text = pacijent.lastname
        containerView.dateTv.text = pacijent.otpusten
        if(pacijent.pic.isNotEmpty())
            Picasso.get().load(pacijent.pic).into(containerView.released_patientPicIv)
    }
}