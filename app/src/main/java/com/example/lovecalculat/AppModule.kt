package com.example.lovecalculat

import com.example.lovecalculat.remote.LoveApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    fun provideApi(): LoveApi{
        return  Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create(Gson())).build().create(LoveApi::class.java)


    }
    @Provides
    fun provideUtils() : Utils{
        return Utils()
    }
    }
