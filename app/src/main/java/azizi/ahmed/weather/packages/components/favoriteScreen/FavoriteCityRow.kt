package azizi.ahmed.weather.packages.components.favoriteScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.model.FavoriteEntity
import azizi.ahmed.weather.packages.navigation.WeatherScreens
import azizi.ahmed.weather.packages.screensAndViewModel.favorites.FavoritesViewModel

@Composable
fun FavoriteCityRow(
    modifier: Modifier = Modifier,
    favorite: FavoriteEntity,
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .size(90.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate(WeatherScreens.MainScreen.route +"/${favorite.city}")
            },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF72BAB1)
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = favorite.city,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Surface(
                modifier = modifier
                    .size(50.dp),
                shape = CircleShape,
                color = Color.Green
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = favorite.country,
                        color = Color.White,
                        fontSize = 30.sp,
                    )
                }
            }

            IconButton(
                onClick = {
                    favoritesViewModel.deleteFavoriteByCity(favorite.city)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
        }
    }
}