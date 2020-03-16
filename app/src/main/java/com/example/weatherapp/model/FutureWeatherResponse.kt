package com.example.weatherapp.model

data class FutureWeatherResponse(var list: List<FutureWeatherPoko>)

data class FutureWeatherPoko(
    var main: FutureTempPoko,
    var weather: List<FutureIDPoko>,
    var dt_txt: String = "02041997"
)
data class FutureTempPoko(
    var temp: String
)
data class FutureIDPoko(
    var icon: String
)


