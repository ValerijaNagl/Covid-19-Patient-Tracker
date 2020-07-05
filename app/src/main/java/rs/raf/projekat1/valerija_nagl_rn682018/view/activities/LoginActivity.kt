package com.example.vezbe6.valerija_nagl_rn682018.application.view.activities



import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vezbe6.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    companion object {
        const val KEY = "User"
        const val PIN = "1234"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear().apply()

        loginBtn.setOnClickListener {

             if (checkInput()) {

                val korisnik: String = usernameTi.text.toString() + "," + lastnameTi.text.toString() + "," + hospitalTi.text.toString()
                editor.putString(KEY, korisnik).apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

    // validacija unosa
    private fun checkInput(): Boolean  {

        var answer : Boolean = true

        if(usernameTi.text.isEmpty()  || lastnameTi.text.isEmpty() || hospitalTi.text.isEmpty()){
            greskaTv.text = getString(R.string.login_greska_prazno)
            answer = false
        }else{
            greskaTv.text = getString(R.string.prazan_str)
        }

        if(pinTi.text.isEmpty()){
            greskaPinTv.text = getString(R.string.login_greska_pin_prazan)
            answer = false
        }else{
            if(pinTi.text.length != 4){
                greskaPinTv.text = getString(R.string.login_greska_pin_duzina)
                answer = false
            }else{
                try {
                    val num = Integer.parseInt(pinTi.text.toString())

                    if(pinTi.text.toString() != PIN){
                        greskaPinTv.text = getString(R.string.login_greska_pin_pogresan)
                        answer = false
                    }else{
                        greskaPinTv.text = getString(R.string.prazan_str)
                    }

                } catch (e: NumberFormatException) {
                    greskaPinTv.text = getString(R.string.login_greska_pin_duzina)
                    answer = false
                }
            }
        }

        return answer
    }
}

