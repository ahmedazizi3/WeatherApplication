package azizi.ahmed.weather.packages.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import azizi.ahmed.weather.packages.screens.aboutScreen.AboutAppScreen
import azizi.ahmed.weather.packages.screens.favoriteScreen.FavoritesScreen
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
                    navController = navController,
                    navigateToSearchScreen = {
                        navController.navigate(WeatherScreens.SearchScreen.route)
                    },
                    city = city,
                    navigateToFavoriteScreen = {
                        navController.navigate(WeatherScreens.FavoriteScreen.route)
                    },
                    navigateToAboutScreen = {
                        navController.navigate(WeatherScreens.AboutAppScreen.route)
                    },
                    navigateToSettingsScreen = {
                        navController.navigate(WeatherScreens.SettingsScreen.route)
                    }
                )
            }
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