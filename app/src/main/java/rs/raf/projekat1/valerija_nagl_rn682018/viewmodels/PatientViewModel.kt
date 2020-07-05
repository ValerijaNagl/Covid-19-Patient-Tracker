package com.example.vezbe6.valerija_nagl_rn682018.application.viewmodels



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vezbe6.valerija_nagl_rn682018.application.model.Patient

class PatientViewModel : ViewModel(){

    private val patientList : MutableList<Patient> = mutableListOf()
    private val patientList2 : MutableList<Patient> = mutableListOf()
    private val patientList3 : MutableList<Patient> = mutableListOf()
    private val patients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patients2 : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patients3 : MutableLiveData<List<Patient>> = MutableLiveData()

    init{
        for (i in 0..10){
            val patient : Patient
            if(i%2==0){
                patient = Patient(i, "U_cekaonici$i", "Prezime$i", "Bol u misicima i kasalj",
                    "Temperatura","Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/04/18/08/37/coronavirus-5058261_960_720.png")
            }else{
                patient = Patient(i, "Ime$i", "Waiting$i", "Visoka temperatura", "Temperatura",
                    "Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/04/18/08/37/coronavirus-5058261_960_720.png")
            }
            patientList.add(patient)
        }

        for (i in 11..21){
            val patient : Patient
            if(i%2==0){
                patient = Patient(i, "Ime$i", "Hospitalizovani$i", "Bol u misicima i kasalj",
                    "Temperatura","Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/03/20/19/55/corona-4951827_960_720.png")
            }else{
                patient = Patient(i, "Hospitalized$i", "Lastname$i", "Bol u misicima i kasalj",
                    "Temperatura","Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/03/20/19/55/corona-4951827_960_720.png")
            }
            patientList2.add(patient)
        }

        for (i in 22..32){
            val patient : Patient
            if(i%2==0){
                patient = Patient(i, "Otpusteni$i", "Lastname$i", "Bol u misicima i kasalj",
                    "Temperatura","Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/04/19/06/51/coronavirus-5062117_960_720.png")
            }else{
                patient = Patient(i, "Released$i", "Prezime$i", "Bol u misicima i kasalj",
                    "Temperatura","Primljen:23.4.2020","Otpusten:20.5.2020",
                    "https://cdn.pixabay.com/photo/2020/04/19/06/51/coronavirus-5062117_960_720.png")
            }
            patientList3.add(patient)
        }

        val tmp1 : MutableList<Patient> = mutableListOf()
        val tmp2 : MutableList<Patient> = mutableListOf()
        val tmp3 : MutableList<Patient> = mutableListOf()
        tmp1.addAll(patientList)
        tmp2.addAll(patientList2)
        tmp3.addAll(patientList3)

        patients.value = tmp1
        patients2.value = tmp2
        patients3.value = tmp3
    }

    fun getWaitingPatients() : LiveData<List<Patient>> {
        return patients;
    }

    fun getHospitalizedPatients() : LiveData<List<Patient>> {
        return patients2;
    }

    fun getReleasedPatients() : LiveData<List<Patient>> {
        return patients3;
    }

    fun getPatientList1() : MutableList<Patient> {
        return patientList;
    }

    fun getPatientList2() : MutableList<Patient> {
        return patientList2;
    }

    fun getPatientList3() : MutableList<Patient> {
        return patientList3;
    }

    fun filterWaitingPatient(filter : String){
        val patientFilter = patientList.filter {
            it.name.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.lastname.toLowerCase().startsWith(filter.toLowerCase())
        }
        patients.value = patientFilter
    }

    fun filterHospitalizedPatient(filter : String){
        val patientFilter = patientList2.filter {
            it.name.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.lastname.toLowerCase().startsWith(filter.toLowerCase())
        }
        patients2.value = patientFilter
    }

    fun filterReleasedPatient(filter : String){
        val patientFilter = patientList3.filter {
            it.name.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.lastname.toLowerCase().startsWith(filter.toLowerCase())
        }
        patients3.value = patientFilter
    }

    fun deleteHealthyPatient(pacijent : Patient){
        patientList.remove(pacijent)
        val listToSubmit : MutableList<Patient> = mutableListOf()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit
    }

    fun addPatientToWaitingRoom(pacijent : Patient){
        patientList.add(pacijent)
        val listToSubmit : MutableList<Patient> = mutableListOf()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit
    }

    fun hospitalizePatient(pacijent : Patient){

        patientList2.add(pacijent)
        val listToSubmit2 : MutableList<Patient> = mutableListOf()
        listToSubmit2.addAll(patientList2)
        patients2.value = listToSubmit2

        patientList.remove(pacijent)
        val listToSubmit : MutableList<Patient> = mutableListOf()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit

    }

    fun releasePatient(pacijent : Patient){

        patientList3.add(pacijent)
        val newList : MutableList<Patient> = mutableListOf()
        newList.addAll(patientList3)
        patients3.value = newList

        patientList2.remove(pacijent)
        val listToSubmit : MutableList<Patient> = mutableListOf()
        listToSubmit.addAll(patientList2)
        patients2.value = listToSubmit

    }

    fun refreshPatientsData(pacijent : Patient){

        val patient = patientList2.find { patient -> pacijent.id == patient.id }
        val index = patientList2.indexOf(patient)

        if (pacijent != null) {
            patientList2.remove(patient)
            patientList2.add(index, pacijent)
        }

        val listToSubmit : MutableList<Patient> = mutableListOf()
        listToSubmit.addAll(patientList2)
        patients2.value = listToSubmit

    }


}