package azizi.ahmed.weather.packages.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import azizi.ahmed.weather.packages.screens.aboutScreen.AboutAppScreen
import azizi.ahmed.weather.packages.screens.favoriteScreen.FavoriteScreen
import azizi.ahmed.weather.packages.screens.mainScreen.MainScreen
import azizi.ahmed.weather.packages.screens.searchScreen.SearchScreen
import azizi.ahmed.weather.packages.screens.settingsScreen.SettingsScreen
import azizi.ahmed.weather.packages.screens.splashScreen.SplashScreen

@Composable
fun WeatherNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.route
    ) {
        composable(
            route = WeatherScreens.SplashScreen.route
        ) {
            SplashScreen {
                navController.navigate(WeatherScreens.MainScreen.route)
            }
        }

        composable(
            route = WeatherScreens.MainScreen.route
        ) {
            MainScreen(
                navController = navController
            )
        }

        composable(
            route = WeatherScreens.AboutAppScreen.route
        ) {
            AboutAppScreen(
                navController = navController
            )
        }

        composable(
            route = WeatherScreens.FavoriteScreen.route
        ) {
            FavoriteScreen(
                navController = navController
            )
        }

        composable(
            route = WeatherScreens.SearchScreen.route
        ) {
            SearchScreen(
                navController = navController
            )
        }

        composable(
            route = WeatherScreens.SettingsScreen.route
        ) {
            SettingsScreen(
                navController = navController
            )
        }
    }
}