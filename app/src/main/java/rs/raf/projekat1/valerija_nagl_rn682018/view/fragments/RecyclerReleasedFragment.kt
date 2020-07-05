package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter.ReleasedPatientsAdapter
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.ReleasedPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels.PatientViewModel
import kotlinx.android.synthetic.main.activity_recycler.*


class RecyclerReleasedFragment : Fragment(R.layout.activity_recycler) {

    private val recyclerViewModel: PatientViewModel by activityViewModels()
    private lateinit var releasedAdapter : ReleasedPatientsAdapter

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
        filterReleasedPatientEt.doAfterTextChanged {
            recyclerViewModel.filterReleasedPatient(filterReleasedPatientEt.text.toString())
        }
        filterReleasedBtn.setOnClickListener{
            recyclerViewModel.filterReleasedPatient(filterReleasedPatientEt.text.toString())
        }
    }

    private fun initRecycler(){
        listReleasedRv.layoutManager = GridLayoutManager(this.context, 2)
        releasedAdapter = ReleasedPatientsAdapter(ReleasedPatientsDiffItemCallback())
        listReleasedRv.adapter = releasedAdapter

    }

    private fun initObservers(){
        recyclerViewModel.getReleasedPatients().observe(viewLifecycleOwner, Observer {
            releasedAdapter.submitList(it)
        })
    }

}
