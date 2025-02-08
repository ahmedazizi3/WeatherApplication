package azizi.ahmed.weather.packages.screens.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar
import azizi.ahmed.weather.packages.components.mainScreen.DayRow
import azizi.ahmed.weather.packages.components.mainScreen.HumidityWindPressureRow
import azizi.ahmed.weather.packages.components.mainScreen.SunSetAndSunRiseRow
import azizi.ahmed.weather.packages.components.mainScreen.TopCircle
import azizi.ahmed.weather.packages.data.WeatherDataOrException
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.packages.model.WeatherItem
import azizi.ahmed.weather.packages.utils.dateFormatter
import azizi.ahmed.weather.packages.viewModel.MainScreenViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController = rememberNavController(),
    navigateToSearchScreen: () -> Unit = {},
    navigateToFavoriteScreen: () -> Unit = {},
    navigateToAboutScreen: () -> Unit = {},
    navigateToSettingsScreen: () -> Unit = {},
) {

    val weatherData = produceState<WeatherDataOrException<Weather, Boolean, Exception>>(
        initialValue = WeatherDataOrException(loading = true)
    ) {
        value = mainScreenViewModel.getWeatherData(city = "Ouargla")
    }.value


    if(weatherData.loading == true) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = Color.LightGray
            )
        }
    } else if(weatherData.data != null) {
        Spacer(
            modifier = modifier
                .height(20.dp)
                .background(Color.Transparent)
        )
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White),
            topBar = {
                WeatherTopBar(
                    title = "${weatherData.data!!.city.name}, ${weatherData.data!!.city.country}",
                    icon1 = Icons.Default.Search,
                    icon2 = Icons.Default.MoreVert,
                    elevation = 0.dp,
                    isMainScreen = true,
                    onIcon1Clicked = {
                        navigateToSearchScreen()
                    },
                    onIcon2Clicked = {}
                )
            }
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = modifier.height(10.dp))

                Text(
                    text = dateFormatter(weatherData.data!!.list[0].date.toLong()) ,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.LightGray
                )

                TopCircle(
                    data = weatherData.data!!
                )

                HumidityWindPressureRow(weather = weatherData.data!!)

                HorizontalDivider(
                    color = Color.LightGray
                )

                SunSetAndSunRiseRow(
                    weather = weatherData.data!!
                )

                Text(
                    text = "7 Days Forecast",
                    color = Color.LightGray,
                    fontSize = 25.sp
                )

                Spacer(modifier = modifier.height(10.dp))

                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    items(
                        items = weatherData.data!!.list
                    ) { item: WeatherItem ->
                        DayRow(
                            weather = item
                        )
                    }
                }
            }
        }
    }
}