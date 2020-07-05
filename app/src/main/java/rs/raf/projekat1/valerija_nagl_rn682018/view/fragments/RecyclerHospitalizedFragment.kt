package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.adapter.HospitalizedPatientsAdapter
import com.example.vezbe6.valerija_nagl_rn682018.application.view.recycler.diff.HospitalizedPatientsDiffItemCallback
import com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels.PatientViewModel
import kotlinx.android.synthetic.main.fragment_recycler_hospitalizovani.*
import androidx.lifecycle.Observer
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import rs.raf.projekat1.valerija_nagl_rn682018.view.activities.ChangeProfileInfoActivity
import rs.raf.projekat1.valerija_nagl_rn682018.view.activities.MedicalRecordActivity
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


class RecyclerHospitalizedFragment() : Fragment(R.layout.fragment_recycler_hospitalizovani) {

    companion object {
        const val REQUEST_CODE = 2
        const val RECEIVED_KEY = "receivedKey"
    }

    private val recyclerViewModel: PatientViewModel by activityViewModels()
    private lateinit var hospitalizedAdapter : HospitalizedPatientsAdapter


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
        filterHospitalizedEt.doAfterTextChanged {
            recyclerViewModel.filterHospitalizedPatient(filterHospitalizedEt.text.toString())
        }
        filterHospitalizedBtn.setOnClickListener{
            recyclerViewModel.filterHospitalizedPatient(filterHospitalizedEt.text.toString())
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun initRecycler(){
        listHospitalizovaniRv.layoutManager = LinearLayoutManager(activity)
        hospitalizedAdapter = HospitalizedPatientsAdapter(HospitalizedPatientsDiffItemCallback()){ patient: Patient, btn: String ->


            if(btn == "kartonBtn"){

                if (patient != null) {
                    val intent = Intent(this.activity, MedicalRecordActivity::class.java)
                    intent.putExtra(MedicalRecordActivity.PATIENT_KEY, patient)
                    startActivityForResult(intent, REQUEST_CODE)
                }

            }else if(btn == "otpustBtn"){

                val sdf = SimpleDateFormat("dd.M.yyyy")
                val currentDate = sdf.format(Date())

                if (patient != null) {
                    patient.otpusten = "Otpusten:"+currentDate
                    recyclerViewModel.releasePatient(patient)

                }
            }
        }

        listHospitalizovaniRv.adapter = hospitalizedAdapter
    }

    private fun initObservers(){
        recyclerViewModel.getHospitalizedPatients().observe(viewLifecycleOwner,Observer {
            hospitalizedAdapter.submitList(it)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK){

                    val patient : Patient? = data?.extras?.getParcelable(RECEIVED_KEY)
                    if (patient != null) {
                        recyclerViewModel.refreshPatientsData(patient)
                    }
                }else{
                    return
                }
            }
        }
    }

}
