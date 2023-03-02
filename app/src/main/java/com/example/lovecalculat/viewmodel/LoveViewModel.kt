package com.example.lovecalculat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculat.remote.LoveModel
import com.example.lovecalculat.repository.Repository

class LoveViewModel: ViewModel() {
    private val repository = Repository()

    fun getLiveLove(firstName:String, secondName: String): LiveData<LoveModel>{
        return repository.getLove(firstName, secondName)

    }
}
