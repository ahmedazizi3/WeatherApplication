package azizi.ahmed.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import azizi.ahmed.weather.packages.navigation.WeatherNavigation

@Composable
fun WeatherMainApp(
    modifier: Modifier = Modifier
) {
    WeatherNavigation()
}