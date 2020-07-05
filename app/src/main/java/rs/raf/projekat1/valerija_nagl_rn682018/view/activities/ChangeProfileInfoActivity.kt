package rs.raf.projekat1.valerija_nagl_rn682018.view.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.view.activities.LoginActivity
import kotlinx.android.synthetic.main.activity_change.*
import kotlinx.android.synthetic.main.activity_medical_record.*
import kotlinx.android.synthetic.main.fragment_add_patient.*

class ChangeProfileInfoActivity : AppCompatActivity(R.layout.activity_change) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){

        val sharedpref = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val user = sharedpref.getString(LoginActivity.KEY, "") ?: ""
        val userInfo = user.split(",")

        change_nameEt.setText(userInfo[0])
        change_lastnameEt.setText(userInfo[1])
        change_hospitalEt.setText(userInfo[2])

        odustaniBtn.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        izmeni_infoBtn.setOnClickListener{
            if(checkInput()){
                val newInfo = change_nameEt.text.toString() + "," + change_lastnameEt.text.toString() + "," + change_hospitalEt.text.toString()
                val editor = sharedpref.edit()
                editor.clear().apply()
                editor.putString(LoginActivity.KEY, newInfo).apply()
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }


    // validacija unosa
    private fun checkInput(): Boolean  {

        var answer : Boolean = true

        if(change_hospitalEt.text.isEmpty()  || change_lastnameEt.text.isEmpty() || change_nameEt.text.isEmpty()){
            change_greskaTv.text = getString(R.string.login_greska_prazno)
            answer = false
        }else{
            change_greskaTv.text = ""
        }
        return answer
    }





}
