package com.example.lovecalculat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.lovecalculat.databinding.ActivityMainBinding
import com.example.lovecalculat.remote.LoveModel
import com.example.lovecalculat.remote.LoveService
import com.example.lovecalculat.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    companion object {
        const val INTENT_FOR_RESULT = "RESULT"
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.getLiveLove(firstET.text.toString(), secondET.text.toString()).
                observe(this@MainActivity, Observer {loveModel->
                    Log.e("ololo", "initClicker:$loveModel")
                })

            }
        }
    }
}