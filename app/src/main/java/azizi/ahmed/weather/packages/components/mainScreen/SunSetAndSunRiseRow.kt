package azizi.ahmed.weather.packages.components.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import azizi.ahmed.weather.packages.model.Weather
import azizi.ahmed.weather.R
import azizi.ahmed.weather.packages.utils.dateFormatter
import azizi.ahmed.weather.packages.utils.timeFormatter


@Composable
fun SunSetAndSunRiseRow(
    modifier: Modifier = Modifier,
    weather: Weather
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "SunRise Icon",
                tint = Color.LightGray,
                modifier = modifier.size(30.dp)
            )
            Text(
                text = timeFormatter(weather.list[0].sunrise.toLong()),
                color = Color.LightGray
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "SunSet Icon",
                tint = Color.LightGray,
                modifier = modifier.size(30.dp)
            )
            Text(
                text = timeFormatter(weather.list[0].sunset.toLong()),
                color = Color.LightGray
            )
        }
    }
}