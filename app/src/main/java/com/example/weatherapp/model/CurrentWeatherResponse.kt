package com.example.weatherapp.model

data class CurrentWeatherResponse(var weather: List<CurrentStatusPoko>,
                                  var main: CurrentTempPoko,
                                  var name: String = "ghghj")

data class CurrentStatusPoko(
    var main: String

)
data class CurrentTempPoko(
    var temp: Float
)

