package com.bounhackers.wowservice.appservice

import com.bounhackers.wowservice.Constants
import com.bounhackers.wowservice.appservice.model.LoginModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.net.CookieHandler
import java.net.CookieManager
import java.util.concurrent.TimeUnit

interface AppServiceInterface {

    @POST("/parents/login")
    fun parentLogin(@Body requestBody: LoginModel.LoginRequestBody): Observable<LoginModel.LoginResponse>

    companion object Factory {
        fun create(): AppServiceInterface {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val handler: CookieHandler = CookieManager()
            val client: OkHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .cookieJar(JavaNetCookieJar(handler))
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .build()
            return retrofit.create(AppServiceInterface::class.java)
        }
    }
}