package com.example.weatherapp.model

import retrofit2.Call
import retrofit2.http.GET

interface FutureWeatherApi {
    @GET("forecast?q=Marietta&appid=b5df03aaf555ef3ad7f3acc64ac7ab92")
    fun getFuture(): Call<FutureWeatherResponse>
}