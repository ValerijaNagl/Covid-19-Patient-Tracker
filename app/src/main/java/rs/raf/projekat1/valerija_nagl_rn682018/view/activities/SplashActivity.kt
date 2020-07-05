package com.example.vezbe6.valerija_nagl_rn682018.application.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vezbe6.R
import timber.log.Timber

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val user : String? = sharedPreferences.getString(LoginActivity.KEY,null)

        if(user != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }else{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}
