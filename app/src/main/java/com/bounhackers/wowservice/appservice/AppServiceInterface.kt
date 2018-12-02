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

    @POST("/api/v1/parents/login")
    fun parentLogin(@Body requestBody: Login.LoginRequestBody): Observable<Model.Parent>

    @GET("/api/v1/parents")
    fun getParentList(): Observable<List<Model.Parent>>

    @GET("/api/v1/parents/{id}")
    fun getParent(@Path("id") id: Long): Observable<Model.Parent>

    @POST("/api/v1/parents")
    fun registerParent(@Body requestBody: Parent.RegisterParentRequest): Observable<Model.Parent>

    @DELETE("/api/v1/parents/{id}")
    fun deleteParent(@Path("id") id: Long): Observable<Unit>



    @GET("/api/v1/kids")
    fun getKidList(): Observable<List<Model.Kid>>

    @GET("/api/v1/kids/{id}")
    fun getKid(@Path("id") id: Long): Observable<Model.Kid>

    @POST("/api/v1/kids")
    fun addKid(@Body requestBody: Kid.RegisterKidRequest): Observable<Model.Kid>

    @DELETE("/api/v1/kids/{id}")
    fun deleteKid(@Path("id") id: Long): Observable<Unit>



    @GET("/api/v1/drivers")
    fun getDriverList(): Observable<List<Model.Driver>>

    @GET("/api/v1/drivers/{id}")
    fun getDriver(@Path("id") id: Long): Observable<Model.Driver>

    @POST("/api/v1/drivers")
    fun createDriver(@Body requestBody: Driver.CreateDriverRequest): Observable<Model.Driver>

    @DELETE("/api/v1/drivers/{id}")
    fun deleteDriver(@Path("id") id: Long): Observable<Unit>



    @GET("/api/v1/routes")
    fun getRouteList(): Observable<List<Model.Route>>

    @GET("/api/v1/routes/{id}")
    fun getRoute(@Path("id") id: Long): Observable<Model.Route>

    @POST("/api/v1/routes")
    fun addRoute(@Body requestBody: Route.CreateRouteRequest): Observable<Model.Route>

    @PUT("/api/v1/routes/{id}")
    fun updateRoute(@Body requestBody: Route.UpdateRouteRequest): Observable<Model.Route>

    @DELETE("/api/v1/routes/{id}")
    fun deleteRoute(@Path("id") id: Long): Observable<Unit>



    @GET("/api/v1/schools")
    fun getSchoolList(): Observable<List<Model.School>>

    @GET("/api/v1/schools/{id}")
    fun getSchool(@Path("id") id: Long): Observable<Model.School>

    @POST("/api/v1/schools")
    fun createSchool(@Body requestBody: School.CreateSchoolRequest): Observable<Model.School>

    @DELETE("/api/v1/schools/{id}")
    fun deleteSchool(@Path("id") id: Long): Observable<Unit>


    @GET("/api/v1/mercedes/vehicles")
    fun getVehicles(@Query("access_token") accessToken: String): Observable<List<Model.Vehicle>>

    @GET("/api/v1/mercedes/vehicle_location/{id}")
    fun getVehicleLoc(@Path("id") id: String, @Query("access_token") accessToken: String): Observable<Vehicle.Location>

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