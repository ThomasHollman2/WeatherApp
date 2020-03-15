package com.example.weatherapp.viewmodel

import android.content.Context
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.CurrentWeatherResponse
import com.example.weatherapp.model.FutureWeatherResponse
import com.example.weatherapp.model.Network

class WeatherViewModel(val baseUrl: String): ViewModel() {
    private val TAG = WeatherViewModel::class.java.simpleName
    private val currentWeather: MutableLiveData<CurrentWeatherResponse> = MutableLiveData()
    private val futureWeather: MutableLiveData<FutureWeatherResponse> = MutableLiveData()



    fun initWeather(){
        val weather = Network(this)
        weather.initRetrofit(baseUrl)
    }
    fun getCurrentData(dataSet: CurrentWeatherResponse) {
        Log.d(TAG, "getCurrentData")
        this.currentWeather.value = dataSet
        Log.d(TAG, "dataSet: " + dataSet.weather + dataSet.main + dataSet.name)
    }
    fun getCurrentDataSet(): LiveData<CurrentWeatherResponse>{
        return currentWeather
    }

    fun getFutureData(dataSet: FutureWeatherResponse) {
        Log.d(TAG, "getFutureData")
        this.futureWeather.value = dataSet
        Log.d(TAG, "dataSet: "
                + dataSet.list[0].main.temp
                + dataSet.list[1].weather[0].icon
                + dataSet.list[2].dt_txt)
    }
    fun getFutureDataSet(): LiveData<FutureWeatherResponse>{
        return futureWeather
    }
}

