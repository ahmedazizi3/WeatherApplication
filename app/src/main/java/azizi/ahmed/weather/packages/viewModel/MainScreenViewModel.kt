package azizi.ahmed.weather.packages.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.ahmed.weather.packages.data.WeatherDataOrException
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.model.WeatherObject
import azizi.ahmed.weather.packages.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {
    suspend fun getWeatherData(city: String): WeatherDataOrException<Weather, Boolean, Exception> {
        return weatherRepository.getWeather(cityQuery = city)
    }
}