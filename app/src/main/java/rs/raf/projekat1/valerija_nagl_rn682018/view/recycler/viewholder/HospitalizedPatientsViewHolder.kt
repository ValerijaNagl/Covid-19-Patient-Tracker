package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hospitalized_patient_item.view.*

class HospitalizedPatientsViewHolder(override val containerView: View, onItemClicked: (Int, String) -> Unit): RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {

        containerView.kartonBtn.setOnClickListener {
            onItemClicked.invoke(adapterPosition,"kartonBtn")
        }

        containerView.otpustBtn.setOnClickListener {
            onItemClicked.invoke(adapterPosition,"otpustBtn")
        }

    }

    fun bind(pacijent : Patient){
        containerView.name_hospitalizedTv.text = pacijent.name
        containerView.lastname_hospitalizedTv.text = pacijent.lastname

        if(pacijent.pic.isNotEmpty())
        Picasso.get().load(pacijent.pic).into(containerView.pacijent_hospitalizedIv)
    }

}