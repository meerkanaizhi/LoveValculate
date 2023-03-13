package com.example.lovecalculat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculat.databinding.ActivityHistoryBinding
import com.example.lovecalculat.databinding.ActivityOnboardBinding

class HistoryActivity:AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = App.appDatabase.loveDao().getAll()
        var data = ""
        list.forEach {
            data += "${it.firstName} \n ${it.secondName} \n ${it.percentage} \n\n\n"
        }
        binding.resultTv.text = data



    }
}
