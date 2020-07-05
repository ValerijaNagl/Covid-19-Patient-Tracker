package com.example.vezbe6.valerija_nagl_rn682018.application.view.fragments

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.content.Intent
import android.graphics.Color
import com.example.vezbe6.R
import com.example.vezbe6.valerija_nagl_rn682018.application.view.activities.LoginActivity
import com.example.vezbe6.valerija_nagl_rn682018.application.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.valerija_nagl_rn682018.view.activities.ChangeProfileInfoActivity
import timber.log.Timber


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init () {
        initListeners()
        initUser()
    }

    fun initListeners(){

        izmeniBtn.setOnClickListener{
            val intent = Intent(this.activity, ChangeProfileInfoActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        odjavaBtn.setOnClickListener{
            val intent = Intent(this.activity, LoginActivity::class.java)
            startActivity(intent)
            this.activity?.finish()
        }

    }

    private fun initUser() {

        val sharedpref = context?.getSharedPreferences(requireActivity().packageName, MODE_PRIVATE)
        val user = sharedpref?.getString(LoginActivity.KEY, "") ?: ""
        val userInfo : List<String> = user.split(",")

        profil_nameTv.text = userInfo[0]
        profil_nameTv.setTextColor(Color.GRAY)

        profil_lastnameTv.text = userInfo[1]
        profil_lastnameTv.setTextColor(Color.GRAY)

        profil_hospitalTv.text = userInfo[2]
        profil_hospitalTv.setTextColor(Color.GRAY)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    initUser()
               }else{
                    return
                }
            }
        }
    }


}


