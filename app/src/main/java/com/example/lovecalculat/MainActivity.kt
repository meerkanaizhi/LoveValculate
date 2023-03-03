package com.example.lovecalculat

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculat.databinding.ActivityMainBinding
import com.example.lovecalculat.remote.LoveModel
import com.example.lovecalculat.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

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
       //         viewModel.getLiveLove(firstET.text.toString(), secondET.text.toString()).
         //       observe(this@MainActivity, Observer {loveModel->
           //         Log.e("ololo", "initClicker:$loveModel")
             //   })
            utils.showToast(this@MainActivity)
            }
        }
    }
}