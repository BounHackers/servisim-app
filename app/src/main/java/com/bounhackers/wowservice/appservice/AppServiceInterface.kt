package com.bounhackers.wowservice.appservice

import com.bounhackers.wowservice.Constants
import com.bounhackers.wowservice.appservice.model.LoginModel
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AppServiceInterface {

    @POST("/parents/login")
    fun parentLogin(@Body requestBody: LoginModel.LoginRequestBody): Observable<LoginModel.LoginResponse>

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