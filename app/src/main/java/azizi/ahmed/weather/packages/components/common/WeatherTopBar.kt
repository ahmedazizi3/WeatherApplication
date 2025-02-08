package azizi.ahmed.weather.packages.components.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeatherTopBar(
    modifier: Modifier = Modifier,
    title: String = "City, Country",
    icon1: ImageVector? = null,
    icon2: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    onAddClicked: () -> Unit = {},
    onIcon1Clicked: () -> Unit = {},
    onIcon2Clicked: () -> Unit = {},

    ) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 40.dp, end = 5.dp, start = 5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        ),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.DarkGray,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.DarkGray,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        )
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Row(
                modifier = modifier
                    .background(Color.Transparent)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.LightGray,
                    modifier = modifier.padding(
                        top = 0.dp,
                        start = 90.dp
                    )
                )
            }
            Row(
                modifier = modifier
                    .background(Color.Transparent)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isMainScreen) {
                    if (icon1 != null) {
                        IconButton(
                            onClick = {
                                onIcon1Clicked()
                            }
                        ) {
                            Icon(
                                imageVector = icon1,
                                contentDescription = "",
                                modifier = modifier
                                    .padding(
                                        top = 0.dp
                                    ),
                                tint = Color.LightGray
                            )
                        }
                    }
                    if (icon2 != null) {
                        IconButton(
                            onClick = {
                                onIcon2Clicked()
                            }
                        ) {
                            Icon(
                                imageVector = icon2,
                                contentDescription = "",
                                tint = Color.LightGray
                            )
                        }
                    }
                } else {
                    Box {}
                }
                Spacer(modifier = modifier.width(10.dp))
            }
            Row(
                modifier = modifier
                    .background(Color.Transparent)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!isMainScreen) {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.LightGray
                        )
                    }
                }
            }
        }
    }

}