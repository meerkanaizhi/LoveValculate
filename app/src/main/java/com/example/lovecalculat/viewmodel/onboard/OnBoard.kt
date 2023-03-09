package com.example.lovecalculat.viewmodel.onboard

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.lovecalculat.MainActivity
import com.example.lovecalculat.Pref

import com.example.lovecalculat.databinding.ActivityOnboardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoard: AppCompatActivity() {
    private lateinit var binding: ActivityOnboardBinding

@Inject
lateinit var pref : Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        OnViewPager()

    }

    private fun onClick() {
        pref.setOnBoardingSeen(false)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    private fun OnViewPager() {
        val adapter = OnBoardAdapter(this, this::onClick)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)


    }

}