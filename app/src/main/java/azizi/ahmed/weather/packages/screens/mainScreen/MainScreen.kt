package azizi.ahmed.weather.packages.screens.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import azizi.ahmed.weather.packages.data.WeatherDataOrException
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.viewModel.MainScreenViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    val weatherData = produceState<WeatherDataOrException<Weather, Boolean, Exception>>(
        initialValue = WeatherDataOrException(loading = true)
    ) {
        value = mainScreenViewModel.getWeatherData(
            city = "Ouargla"
        )
    }.value

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(weatherData.loading == true) {
            CircularProgressIndicator()
        } else if(weatherData.data != null) {
            Text(
                text = "Main Screen ${weatherData.data!!.city.country}",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.LightGray
            )
        }
    }
}