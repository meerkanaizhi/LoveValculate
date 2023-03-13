package com.example.lovecalculat.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculat.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase :RoomDatabase(){

  abstract  fun loveDao():LoveDao
}