package com.example.weatherapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.model.CurrentWeatherResponse
import com.example.weatherapp.model.FutureWeatherPoko
import com.example.weatherapp.model.FutureWeatherResponse
import com.example.weatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_details.*
import kotlinx.android.synthetic.main.sign_in.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    val futureWeatherAdapter: FutureWeatherAdapter by lazy { FutureWeatherAdapter() }

    var key = "b5df03aaf555ef3ad7f3acc64ac7ab92"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = futureWeatherAdapter
        val currentViewHolder = CurrentWeatherViewHolder(findViewById(R.id.background))

        val viewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    Log.d(TAG, "viewModel = ViewModelProvider")
                    return WeatherViewModel("http://api.openweathermap.org/data/2.5/")
                            as T

                }
            }
        ).get(WeatherViewModel::class.java)
        viewModel.initWeather()
        viewModel.getCurrentDataSet().observe(this,
            object : Observer<CurrentWeatherResponse>{
                override fun onChanged(t: CurrentWeatherResponse?) {
                    currentViewHolder.onBind(t!!)

                }

            })
        val futureViewHolder = FutureWeatherViewHolder(findViewById(R.id.recycler_view))
        viewModel.getFutureDataSet().observe(this,
            object  : Observer<FutureWeatherResponse>{
                override fun onChanged(t: FutureWeatherResponse?) {
                    futureViewHolder.onBind(t!!)
                }
            })


    }

}
