package azizi.ahmed.weather.packages.data

class WeatherDataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: E? = null
)