package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels.PatientViewModel
import kotlinx.android.synthetic.main.fragment_pregled_pacijenata.*


class OverviewFragment : Fragment(R.layout.fragment_pregled_pacijenata) {

    private val recyclerViewModel: PatientViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init(){
        recyclerViewModel.getHospitalizedPatients().observe(viewLifecycleOwner, Observer {
            broj_hosptTv.text = it.size.toString()
        })

        recyclerViewModel.getWaitingPatients().observe(viewLifecycleOwner, Observer {
            broj_u_cekTv.text = it.size.toString()
        })

        recyclerViewModel.getReleasedPatients().observe(viewLifecycleOwner, Observer {
            broj_otpustTv.text = it.size.toString()
        })
    }

}
