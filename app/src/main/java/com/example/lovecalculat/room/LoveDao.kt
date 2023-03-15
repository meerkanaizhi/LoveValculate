package com.example.lovecalculat.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculat.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert (loveModel: LoveModel)

    @Query("SELECT * FROM love_model")
    fun getAll():List<LoveModel>



}