package com.example.lovecalculat.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculat.remote.LoveApi
import com.example.lovecalculat.remote.LoveModel
import com.example.lovecalculat.room.LoveDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val api: LoveApi, val dao: LoveDao){
    fun insert(loveModel: LoveModel) {
        dao.insert(loveModel)
    }

    fun getLove(firstName:String, secondName: String): MutableLiveData<LoveModel>{
        val liveLoveData = MutableLiveData<LoveModel>()

        api.calculateLove(firstName, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())

                               }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }
        })
        return liveLoveData
    }
}