package com.bounhackers.wowservice.appservice

import com.bounhackers.wowservice.Constants
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface AppServiceInterface {

    companion object Factory {
        fun create(): AppServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retrofit.create(AppServiceInterface::class.java)
        }
    }
}