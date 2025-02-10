package azizi.ahmed.weather.packages.screensAndViewModel.main

import androidx.lifecycle.ViewModel
import azizi.ahmed.weather.packages.data.WeatherDataOrException
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {
    suspend fun getWeatherData(city: String): WeatherDataOrException<Weather, Boolean, Exception> {
        return weatherRepository.getWeather(cityQuery = city)
    }
}