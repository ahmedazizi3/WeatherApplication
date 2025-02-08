package azizi.ahmed.weather.packages.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun formatter(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")
        .withZone(ZoneId.systemDefault())

    // Convert seconds to milliseconds
    return formatter.format(Instant.ofEpochSecond(timestamp))
}
