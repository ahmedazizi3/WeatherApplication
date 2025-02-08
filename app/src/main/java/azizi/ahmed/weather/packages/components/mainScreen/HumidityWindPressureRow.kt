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

@Composable
fun HumidityWindPressureRow(
    modifier: Modifier = Modifier,
    weather: Weather
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.humidity),
                contentDescription = "Humidity Icon",
                modifier = modifier.size(20.dp),
                tint = Color.LightGray
            )
            Text(
                text = "${weather.list[0].humidity}%",
                color = Color.LightGray
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.pressure),
                contentDescription = "Pressure Icon",
                modifier = modifier.size(20.dp),
                tint = Color.LightGray
            )
            Text(
                text = "${weather.list[0].pressure}psi",
                color = Color.LightGray
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.wind),
                contentDescription = "Wind Icon",
                modifier = modifier.size(20.dp),
                tint = Color.LightGray
            )
            Text(
                text = "${weather.list[0].humidity} m/h",
                color = Color.LightGray
            )
        }
    }
}