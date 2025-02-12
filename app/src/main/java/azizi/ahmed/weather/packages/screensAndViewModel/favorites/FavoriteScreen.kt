package azizi.ahmed.weather.packages.screensAndViewModel.favorites


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar
import azizi.ahmed.weather.packages.components.favoriteScreen.FavoriteCityRow

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            WeatherTopBar(
                isMainScreen = false,
                onIcon3Clicked = {
                    navController.popBackStack()
                },
                title = "Favorites"
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val favoritesList = favoritesViewModel.favoriteList.collectAsState().value

            LazyColumn {
                items(favoritesList) {
                    FavoriteCityRow(
                        favorite = it,
                        navController = navController
                    )
                }
            }
        }
    }
}