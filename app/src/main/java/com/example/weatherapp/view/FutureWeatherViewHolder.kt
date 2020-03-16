package com.example.weatherapp.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.FutureWeatherPoko
import com.example.weatherapp.model.FutureWeatherResponse
import kotlinx.android.synthetic.main.rv_details.*
import java.util.concurrent.Future


class FutureWeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val TAG = FutureWeatherViewHolder::class.java.simpleName

    val futureDate: TextView = itemView.findViewById(R.id.tv_rv)
//    val futureWeatherTime: TextView = itemView.findViewById(R.id.inner_time)
//    val futureWeatherIcon: ImageView = itemView.findViewById(R.id.inner_icon)


fun onBind(item: FutureWeatherPoko){
    //futureWeatherTemp.text = item.list[0].main.temp
   // futureWeatherTime.text = item.dt_txt
    futureDate.text = item.dt_txt.substringBefore(' ')
    Log.d(TAG, "onBind")


}
}