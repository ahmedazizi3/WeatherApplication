package azizi.ahmed.weather.packages.components.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.weather.packages.model.WeatherItem
import azizi.ahmed.weather.packages.utils.dayNameFormatter

@Composable
fun DayRow(
    modifier: Modifier = Modifier,
    weather: WeatherItem
) {
    val imageURL = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"


    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        color = Color(0xFF3DD9B5),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = dayNameFormatter(weather.date.toLong()),
                color = Color.Black,
                fontSize = 25.sp
            )

            WeatherStateImage(imageURL = imageURL)

            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xffffc400)
                )
            ) {
                Text(
                    text = weather.weather[0].description,
                    color = Color.Black,
                    fontSize = 19.sp,
                    modifier = modifier.padding(5.dp)
                )
            }

            Row {
                Text(
                    text = "${weather.temp.max.toInt()}°",
                    color = Color(0xFFF44336),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${weather.temp.min.toInt()}°",
                    color = Color(0xFF2196F3),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}