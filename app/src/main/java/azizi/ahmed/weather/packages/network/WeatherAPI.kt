package azizi.ahmed.weather.packages.network

import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.model.WeatherObject
import azizi.ahmed.weather.packages.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherAPI {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query(value = "q") query: String,
        @Query(value = "units") units: String = "metric",
        @Query(value = "appid") appid: String = Constants.API_KEY
    ): Weather
}