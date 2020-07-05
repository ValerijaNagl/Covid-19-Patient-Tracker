package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels

import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels.PatientViewModel
import kotlinx.android.synthetic.main.fragment_add_patient.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class AddPatientFragment : Fragment(R.layout.fragment_add_patient) {


    private val recyclerViewModel: PatientViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        // dodavanje novog pacijenta
        addBtn.setOnClickListener{
            if(checkInput()){

                val name : String = add_usernameTi.text.toString()
                val lastname : String = add_lastnameTi.text.toString()
                val simptomi : String = add_simptomiTi.text.toString()
                val sdf = SimpleDateFormat("dd.M.yyyy")
                val currentDate = sdf.format(Date())
                val id = Random.nextInt(0,Int.MAX_VALUE)
                val patient = Patient(id, name, lastname, simptomi, simptomi, "Primljen: "+ currentDate, "Otpusten: "+currentDate,
                    "https://cdn.pixabay.com/photo/2020/04/18/08/37/coronavirus-5058261_960_720.png")

                recyclerViewModel.addPatientToWaitingRoom(patient)

                add_usernameTi.setText(getString(R.string.prazan_str))
                add_lastnameTi.setText(getString(R.string.prazan_str))
                add_simptomiTi.setText(getString(R.string.prazan_str))
            }
        }
    }

    // validacija unosa
    private fun checkInput(): Boolean  {

        var answer : Boolean = true

        if(add_usernameTi.text.isEmpty()  || add_lastnameTi.text.isEmpty() || add_simptomiTi.text.isEmpty()){
            greskaUnosaTv.text = getString(R.string.login_greska_prazno)
            answer = false
        }else{
            greskaUnosaTv.text = getString(R.string.prazan_str)
        }
        return answer
    }


}
