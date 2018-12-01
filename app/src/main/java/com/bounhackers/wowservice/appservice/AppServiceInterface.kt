package com.bounhackers.wowservice.appservice

import com.bounhackers.wowservice.Constants
import com.bounhackers.wowservice.appservice.schemas.*
import com.bounhackers.wowservice.data.Model
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.net.CookieHandler
import java.net.CookieManager
import java.util.concurrent.TimeUnit

interface AppServiceInterface {

    @POST("/parents/login")
    fun parentLogin(@Body requestBody: Login.LoginRequestBody): Observable<Login.LoginResponse>

    @GET("/parents")
    fun getParentList(): Observable<List<Model.Parent>>

    @GET("/parents/{id}")
    fun getParent(@Path("id") id: Long): Observable<Model.Parent>

    @POST("/parents")
    fun registerParent(@Body requestBody: Parent.RegisterParentRequest): Observable<Model.Parent>

    @DELETE("/parents/{id}")
    fun deleteParent(@Path("id") id: Long): Observable<Unit>



    @GET("/kids")
    fun getKidList(): Observable<List<Model.Kid>>

    @GET("/kids/{id}")
    fun getKid(@Path("id") id: Long): Observable<Model.Kid>

    @POST("/kids")
    fun addKid(@Body requestBody: Kid.RegisterKidRequest): Observable<Model.Kid>

    @DELETE("/kids/{id}")
    fun deleteKid(@Path("id") id: Long): Observable<Unit>



    @GET("/drivers")
    fun getDriverList(): Observable<List<Model.Driver>>

    @GET("/drivers/{id}")
    fun getDriver(@Path("id") id: Long): Observable<Model.Driver>

    @POST("/drivers")
    fun createDriver(@Body requestBody: Driver.CreateDriverRequest): Observable<Model.Driver>

    @DELETE("/drivers/{id}")
    fun deleteDriver(@Path("id") id: Long): Observable<Unit>



    @GET("/routes")
    fun getRouteList(): Observable<List<Model.Route>>

    @GET("/routes/{id}")
    fun getRoute(@Path("id") id: Long): Observable<Model.Route>



    @GET("/schools")
    fun getSchoolList(): Observable<List<Model.School>>

    @GET("/schools/{id}")
    fun getSchool(@Path("id") id: Long)

    @POST("/schools")
    fun createSchool(@Body requestBody: School.CreateSchoolRequest)

    @DELETE("/schools/{id}")
    fun deleteSchool(@Path("id") id: Long)



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