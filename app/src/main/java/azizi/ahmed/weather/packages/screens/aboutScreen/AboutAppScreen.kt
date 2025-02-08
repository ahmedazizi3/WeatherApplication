package azizi.ahmed.weather.packages.screens.aboutScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar

@Composable
fun AboutAppScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            WeatherTopBar(
                isMainScreen = false,
                onIcon3Clicked = {
                    navController.popBackStack()
                },
                title = "About App"
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "This is About App Screen",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}