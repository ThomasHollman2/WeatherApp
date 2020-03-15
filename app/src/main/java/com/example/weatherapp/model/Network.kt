package com.example.weatherapp.model

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.example.weatherapp.viewmodel.WeatherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network(val viewModel: WeatherViewModel) {
    private val TAG = Network::class.java.simpleName
    fun initRetrofit(baseUrl: String) {

        getCurrentApi(baseUrl).getCurrent().enqueue(object : Callback<CurrentWeatherResponse> {
            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                Log.d(TAG, "onFailure")

            }
            override fun onResponse(

                call: Call<CurrentWeatherResponse>,
                response: Response<CurrentWeatherResponse>

            ) {
                Log.d(TAG, "onResponse")
                response.body()?.let { viewModel.getCurrentData(it) }
            }
        })

        getFutureApi(baseUrl).getFuture().enqueue(object : Callback<FutureWeatherResponse> {
            override fun onFailure(call: Call<FutureWeatherResponse>, t: Throwable) {
                Log.d(ContentValues.TAG, "onFailure")
            }
            override fun onResponse(
                call: Call<FutureWeatherResponse>,
                response: Response<FutureWeatherResponse>
            ) {
                Log.d(ContentValues.TAG, "onResponse")
                response.body()?.let { viewModel.getFutureData(it) }
            }
        })
    }
    fun getCurrentApi(url: String): CurrentWeatherApi {
        Log.d(TAG, "getCurrentApi")

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build().create(CurrentWeatherApi::class.java)
    }

    fun getFutureApi(url: String): FutureWeatherApi {
        Log.d(TAG, "getFutureApi")

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build().create(FutureWeatherApi::class.java)
    }
}
