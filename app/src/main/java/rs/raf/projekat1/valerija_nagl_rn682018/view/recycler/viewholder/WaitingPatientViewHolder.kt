package com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pacijent_u_cekaonici.view.*


class WaitingPatientViewHolder(override val containerView: View, onItemClicked: (Int, String) -> Unit): RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {

        containerView.zdravBtn.setOnClickListener {
//            val res : String = Integer.toString(adapterPosition)   + ",zdravBtn"
            onItemClicked.invoke(adapterPosition, "zdravBtn")
        }

        containerView.hospitalizacijaBtn.setOnClickListener {
//            val res : String = Integer.toString(adapterPosition)  + ",hospitalizacijaBtn"
            onItemClicked.invoke(adapterPosition, "hospitalizacijaBtn")
        }

    }

    fun bind(pacijent : Patient){
        containerView.nameTv.text = pacijent.name
        containerView.lastnameTv.text = pacijent.lastname
        containerView.simptomsTi.text = pacijent.stanjePriPrijemu

        if(pacijent.pic.isNotEmpty())
            Picasso.get().load(pacijent.pic).into(containerView.patientPicIv)
    }

}