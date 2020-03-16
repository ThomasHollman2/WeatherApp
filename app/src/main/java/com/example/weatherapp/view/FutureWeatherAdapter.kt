package com.example.weatherapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.FutureWeatherResponse


class FutureWeatherAdapter: RecyclerView.Adapter<FutureWeatherViewHolder>() {
    private val TAG = FutureWeatherAdapter::class.java.simpleName
    var dataSet: FutureWeatherResponse? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutureWeatherViewHolder {
    return FutureWeatherViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.rv_details, parent,
    false))}

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount" + dataSet?.list?.size)
        return dataSet?.list?.size ?: 0
    }

    override fun onBindViewHolder(holder: FutureWeatherViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder" + dataSet?.list?.get(position))
        dataSet?.list?.get(position)?.let {holder.onBind(it)}
    }
}