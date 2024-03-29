package com.example.lovecalculat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculat.MainActivity.Companion.INTENT_FOR_RESULT
import com.example.lovecalculat.databinding.ActivityResultBinding
import com.example.lovecalculat.remote.LoveModel

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var loveModel: LoveModel
    private var adapter = HistoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter= adapter
        adapter.setItem(App.appDatabase.loveDao().getAll())

    }

}
