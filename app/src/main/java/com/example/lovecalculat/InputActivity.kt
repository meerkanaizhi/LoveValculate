package com.example.lovecalculat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculat.viewmodel.onboard.OnBoard
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    @Inject
    lateinit var pref : Pref


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        Handler().postDelayed({
            if(pref.isOnBoardingView()){
                startActivity(Intent(this, OnBoard::class.java))
            }else{
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish()
        }, 1000)


    }
}