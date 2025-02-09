package azizi.ahmed.weather.packages.screens.aboutScreen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar
import azizi.ahmed.weather.R

@Composable
fun AboutAppScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    val url = stringResource(id = R.string.apiUsed)


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
                text = stringResource(id = R.string.aboutApp),
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = url,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .clickable {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(context, "Invalid URL", Toast.LENGTH_SHORT).show()
                        }
                    }
            )
        }
    }
}