package azizi.ahmed.weather.packages.components.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.weather.packages.model.Weather

@Composable
fun TopCircle(
    modifier: Modifier = Modifier,
    data: Weather
) {
    val weatherItem = data.list[0]
    val imageURL = "https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}.png"

    Surface(
        modifier = modifier
            .size(200.dp)
            .padding(4.dp),
        shape = CircleShape,
        color = Color(0xffffc400)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WeatherStateImage(imageURL = imageURL)

            Spacer(modifier = modifier.height(6.dp))

            Text(
                text = "${weatherItem.temp.day.toInt()}°",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = modifier.height(6.dp))

            Text(
                text = weatherItem.weather[0].main,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}