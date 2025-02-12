package azizi.ahmed.weather.packages.repository

import azizi.ahmed.weather.packages.data.WeatherDataOrException
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherAPI: WeatherAPI) {
    suspend fun getWeather(
        cityQuery: String,
        unit: String
    ): WeatherDataOrException<Weather, Boolean, Exception> {
        val response = try {
            weatherAPI.getWeather(
                query = cityQuery,
                units = unit
            )
        } catch (exception: Exception) {
            return WeatherDataOrException(exception = exception)
        }
        return WeatherDataOrException(data = response)
    }
}