package com.example.lovecalculat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculat.remote.LoveModel
import com.example.lovecalculat.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor
    (val repository: Repository): ViewModel() {


    fun getLiveLove(firstName:String, secondName: String): LiveData<LoveModel>{
        return repository.getLove(firstName, secondName)

    }
}
