package azizi.ahmed.weather.packages.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import azizi.ahmed.weather.packages.screensAndViewModel.favorites.FavoritesScreen
import azizi.ahmed.weather.packages.screensAndViewModel.main.MainScreen
import azizi.ahmed.weather.packages.screensAndViewModel.search.SearchScreen
import azizi.ahmed.weather.packages.screensAndViewModel.settings.SettingsScreen
import azizi.ahmed.weather.packages.screensAndViewModel.splash.SplashScreen

@Composable
fun WeatherNavigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.route
    ) {
        val defaultCity = "Ouargla"
        composable(
            route = WeatherScreens.SplashScreen.route
        ) {
            SplashScreen {
                navController.navigate(WeatherScreens.MainScreen.route +"/$defaultCity")
            }
        }

        val route = WeatherScreens.MainScreen.route
        composable(
            route = "$route/{city}",
            arguments = listOf(
                navArgument(
                    name = "city"
                ) {
                    type = NavType.StringType
                }
            )
        ) { navBack ->
            navBack.arguments?.getString("city").let { city ->
                MainScreen(
                    city = city,
                    navigateToSearchScreen = {
                        navController.navigate(WeatherScreens.SearchScreen.route)
                    },
                    navigateToFavoriteScreen = {
                        navController.navigate(WeatherScreens.FavoriteScreen.route)
                    },
                    navigateToSettingsScreen = {
                        navController.navigate(WeatherScreens.SettingsScreen.route)
                    }
                )
            }
        }

        composable(
            route = WeatherScreens.FavoriteScreen.route
        ) {
            FavoritesScreen(
                navController = navController
            )
        }

        composable(
            route = WeatherScreens.SearchScreen.route
        ) {
            SearchScreen(
                navController = navController,
                navigateBackToMainScreen = {
                    navController.popBackStack()
                },
                navigateToMainScreen = { mCity ->
                    navController.navigate(WeatherScreens.MainScreen.route +"/$mCity")
                }
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