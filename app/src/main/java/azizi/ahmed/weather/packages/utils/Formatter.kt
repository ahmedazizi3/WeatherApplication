package azizi.ahmed.weather.packages.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun dateFormatter(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")
        .withZone(ZoneId.systemDefault())

    // Convert seconds to milliseconds
    return formatter.format(Instant.ofEpochSecond(timestamp))
}

fun timeFormatter(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
        .withZone(ZoneId.systemDefault())

    return formatter.format(Instant.ofEpochSecond(timestamp))
}

fun dayNameFormatter(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern("EE")
        .withZone(ZoneId.systemDefault())

    // Convert seconds to milliseconds
    return formatter.format(Instant.ofEpochSecond(timestamp))
}

fun formatMilesToKm(miles: Double): String {
    val km = miles * 1.60934
    return String.format("%.2f", km)
}


