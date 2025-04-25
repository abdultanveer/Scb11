package com.example.scb11.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//builder design pattern mandatory params and option param --flat-3M,5l car, 7l, 2l marble, 3l - more ---

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
   suspend fun getPhotos():String

}
//object = singleton design pattern
object MarsApi {
    //by delegation pattern
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)

    }
}


