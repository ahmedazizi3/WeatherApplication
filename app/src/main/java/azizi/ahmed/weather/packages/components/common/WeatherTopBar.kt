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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import azizi.ahmed.weather.packages.components.mainScreen.WeatherDropDownMenu
import azizi.ahmed.weather.packages.screensAndViewModel.favorites.FavoritesViewModel


@Composable
fun WeatherTopBar(
    modifier: Modifier = Modifier,
    title: String = "City, Country",
    icon1: ImageVector? = null,
    icon2: ImageVector? = null,
    isMainScreen: Boolean = true,
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    elevation: Dp = 0.dp,
    onIcon1Clicked: () -> Unit = {},
    onIcon3Clicked: () -> Unit = {},
    navigateToFavoriteScreen: () -> Unit = {},
    navigateToAboutScreen: () -> Unit = {},
    navigateToSettingScreen: () -> Unit = {},
    border: BorderStroke? = null
) {
    val showDialog = remember {
        mutableStateOf(false)
    }




    if(showDialog.value) {
        WeatherDropDownMenu(
            showDialog = showDialog,
            navigateToFavoriteScreen = navigateToFavoriteScreen,
            navigateToAboutScreen = navigateToAboutScreen,
            navigateToSettingScreen = navigateToSettingScreen
        )
    }

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
        border = border
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
                                onIcon1Clicked.invoke()
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
                                showDialog.value = true

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
                            onIcon3Clicked.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.LightGray
                        )
                    }
                } else {
                    IconButton(
                        onClick = {
                            onIcon3Clicked.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "",
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }

}