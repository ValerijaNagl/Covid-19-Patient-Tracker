package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter.WaitingPatientAdapter
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.WaitingPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels.PatientViewModel
import kotlinx.android.synthetic.main.fragment_cekaonica.*


class RecyclerWaitingRoomFragment : Fragment(R.layout.fragment_cekaonica) {

    private val recyclerViewModel: PatientViewModel by activityViewModels()
    private lateinit var cekaonicaAdapter : WaitingPatientAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initListeners()
        initRecycler()
        initObservers()
    }

    private fun initListeners(){
        filterWaitingPatientEt.doAfterTextChanged {
            recyclerViewModel.filterWaitingPatient(filterWaitingPatientEt.text.toString())
        }
        filterWaitingBtn.setOnClickListener{
            recyclerViewModel.filterWaitingPatient(filterWaitingPatientEt.text.toString())
        }
    }

    private fun initRecycler(){
        listCekaonicaRv.layoutManager = LinearLayoutManager(activity)
        cekaonicaAdapter = WaitingPatientAdapter(WaitingPatientsDiffItemCallback()){ patient: Patient, btn: String ->

            if(btn == "zdravBtn"){

                if (patient != null) {
                    recyclerViewModel.deleteHealthyPatient(patient)
                }

            }else if(btn== "hospitalizacijaBtn"){
                if (patient != null) {
                    recyclerViewModel.hospitalizePatient(patient)
                }
            }
        }

        listCekaonicaRv.adapter = cekaonicaAdapter
    }

    private fun initObservers(){
        recyclerViewModel.getWaitingPatients().observe(viewLifecycleOwner,Observer{
            cekaonicaAdapter.submitList(it)
        })
    }

}


