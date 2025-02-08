package azizi.ahmed.weather.packages.components.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherDropDownMenu(
    modifier: Modifier = Modifier,
    showDialog: MutableState<Boolean>,
    navigateToFavoriteScreen: () -> Unit = {},
    navigateToAboutScreen: () -> Unit = {},
    navigateToSettingScreen: () -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(true) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 20.dp)
    ) {
        DropdownMenu(
            modifier = modifier.width(150.dp).background(Color.White),
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = !isExpanded
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Favorites")
                },
                onClick = {
                    isExpanded = !isExpanded
                    showDialog.value = !showDialog.value
                    navigateToFavoriteScreen()
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites"
                    )
                },
                colors = MenuItemColors(
                    textColor = Color.LightGray,
                    leadingIconColor = Color.LightGray,
                    trailingIconColor = Color.LightGray,
                    disabledTextColor = Color.LightGray,
                    disabledLeadingIconColor = Color.LightGray,
                    disabledTrailingIconColor = Color.LightGray,
                )
            )
            DropdownMenuItem(
                text = {
                    Text(text = "About App")
                },
                onClick = {
                    isExpanded = !isExpanded
                    showDialog.value = !showDialog.value
                    navigateToAboutScreen()
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "About"
                    )
                },
                colors = MenuItemColors(
                    textColor = Color.LightGray,
                    leadingIconColor = Color.LightGray,
                    trailingIconColor = Color.LightGray,
                    disabledTextColor = Color.LightGray,
                    disabledLeadingIconColor = Color.LightGray,
                    disabledTrailingIconColor = Color.LightGray,
                )
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Setting")
                },
                onClick = {
                    isExpanded = !isExpanded
                    showDialog.value = !showDialog.value
                    navigateToSettingScreen()
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Setting"
                    )
                },
                colors = MenuItemColors(
                    textColor = Color.LightGray,
                    leadingIconColor = Color.LightGray,
                    trailingIconColor = Color.LightGray,
                    disabledTextColor = Color.LightGray,
                    disabledLeadingIconColor = Color.LightGray,
                    disabledTrailingIconColor = Color.LightGray,
                )
            )

        }
    }
}