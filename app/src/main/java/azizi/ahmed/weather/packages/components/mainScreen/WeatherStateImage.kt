package azizi.ahmed.weather.packages.components.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun WeatherStateImage(
    modifier: Modifier = Modifier,
    imageURL: String
) {
   Image(
       painter = rememberImagePainter(imageURL),
       contentDescription = "",
       modifier = modifier.size(80.dp)
   )
}