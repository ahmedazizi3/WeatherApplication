package azizi.ahmed.weather.packages.screensAndViewModel.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.weather.R
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.scale
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToMainScreen: () -> Unit = {}
) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(
        key1 = true,
        block = {
            scale.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(8f).getInterpolation(it)
                    }
                )
            )
            delay(
                1000L
            )
            navigateToMainScreen()
        }
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Color.White
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = modifier.height(200.dp))
        Surface(
            modifier = modifier
                .padding(20.dp)
                .size(330.dp)
                .align(Alignment.CenterHorizontally)
                .scale(scale = scale.value),
            shape = CircleShape,
            color = Color.White,
            border = BorderStroke(
                width = 2.dp,
                color = Color.LightGray
            ),

        ) {
            Column(
                modifier = modifier
                    .padding(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sun image in the splash screen",
                    colorFilter = ColorFilter.lighting(
                        Color.LightGray,
                        add = Color.LightGray
                    ),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Find the sun!",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
            }
        }


        Text(
            "BY Ahmed Azizi",
            color = Color.LightGray,
            modifier = modifier
                .padding(
                    top = 270.dp, end = 20.dp
                )
                .align(Alignment.End)
        )
    }
}