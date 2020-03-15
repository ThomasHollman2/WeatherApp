package com.example.weatherapp.view

import android.view.View
import android.widget.TextView
import com.example.weatherapp.R
import com.example.weatherapp.model.CurrentStatusPoko
import com.example.weatherapp.model.CurrentTempPoko
import com.example.weatherapp.model.CurrentWeatherResponse
import org.w3c.dom.Text

class CurrentWeatherViewHolder(val itemView: View) {
    val currentWeatherTemp: TextView = itemView.findViewById(R.id.current_weather_temp)
    val location: TextView = itemView.findViewById(R.id.curent_weather_location)
    val status: TextView = itemView.findViewById(R.id.current_weather_status)

    fun onBind(item: CurrentWeatherResponse){
        currentWeatherTemp.text = item.main.temp.toString()
        location.text = item.name
        status.text = item.weather[0].main.toString()
    }
}
