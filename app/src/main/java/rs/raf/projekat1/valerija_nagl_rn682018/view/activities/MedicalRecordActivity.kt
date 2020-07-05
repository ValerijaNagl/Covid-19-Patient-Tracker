package rs.raf.projekat1.valerija_nagl_rn682018.view.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient
import com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments.RecyclerHospitalizedFragment
import kotlinx.android.synthetic.main.activity_medical_record.*

class MedicalRecordActivity : AppCompatActivity(R.layout.activity_medical_record) {

    private var patient: Patient? = null

    companion object {
        const val PATIENT_KEY = "patientKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        parseIntent()
        initListeners()
    }

    private fun initListeners(){

        val returnIntent = Intent()

        karton_odustaniBtn.setOnClickListener{
            setResult(Activity.RESULT_CANCELED, returnIntent)
            finish()
        }

        karton_izmeniBtn.setOnClickListener{
            if(checkInput()){

            patient?.name  = karton_nameEt.text.toString()
            patient?.lastname = karton_lastnameEt.text.toString()
            patient?.stanjePriPrijemu = stanje_pri_prijemuEt.text.toString()
            patient?.trenutnoStanje = tr_stanjeEt.text.toString()
            patient?.primljen = "Primljen:"+datum_prijemaTv.text.toString()

            returnIntent.putExtra(RecyclerHospitalizedFragment.RECEIVED_KEY, patient)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
        }
    }

    private fun parseIntent() {
        intent?.let {

            patient = it.getParcelableExtra(PATIENT_KEY)

            val name : String? = patient?.name
            val lastname : String? = patient?.lastname
            val stanjePriPrijemu : String? = patient?.stanjePriPrijemu
            val trenutnoStanje : String? = patient?.trenutnoStanje
            val arr = patient?.primljen?.split(":")
            val datumPrijema : String? = arr?.get(1)

            karton_nameEt.setText(name)
            karton_lastnameEt.setText(lastname)
            stanje_pri_prijemuEt.setText(stanjePriPrijemu)
            tr_stanjeEt.setText(trenutnoStanje)
            datum_prijemaTv.text = datumPrijema
            datum_prijemaTv.setTextColor(Color.DKGRAY)
        }
    }


    // validacija unosa
    private fun checkInput(): Boolean  {

        var answer : Boolean = true

        if(karton_nameEt.text.isEmpty()  || karton_lastnameEt.text.isEmpty() || stanje_pri_prijemuEt.text.isEmpty() ||
            tr_stanjeEt.text.isEmpty() || datum_prijemaTv.text.isEmpty() ){
            greska_kartonTv.text = getString(R.string.login_greska_prazno)
            answer = false
        }else{
            greska_kartonTv.text = ""
        }
        return answer
    }

}
