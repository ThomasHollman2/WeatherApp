package com.example.weatherapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherApi {
//?q=Marietta&appid=b5df03aaf555ef3ad7f3acc64ac7ab92
    @GET("weather")
    fun getCurrent(@Query("zip") zip:String,@Query("APPID")api:String): Call<CurrentWeatherResponse>
}