package azizi.ahmed.weather.packages.navigation

sealed class WeatherScreens(
    val route: String
) {
    data object SplashScreen: WeatherScreens("splashScreen")
    data object MainScreen: WeatherScreens("mainScreen")
    data object AboutAppScreen: WeatherScreens("aboutAppScreen")
    data object SearchScreen: WeatherScreens("searchScreen")
    data object FavoriteScreen: WeatherScreens("favoriteScreen")
    data object SettingsScreen: WeatherScreens("settingsScreen")
}