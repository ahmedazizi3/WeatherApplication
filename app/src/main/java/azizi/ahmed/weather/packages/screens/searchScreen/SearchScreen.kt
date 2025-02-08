package azizi.ahmed.weather.packages.screens.searchScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateBackToMainScreen: () -> Unit = {},
    navigateToMainScreen: (String?) -> Unit = {},
    placeHolder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onSearch: (String) -> Unit = {
        Log.d("SearchScreen", "onSearch: $it")
        navigateToMainScreen.invoke(it)
    }
) {

    val searchQueryState: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val valid = remember(searchQueryState.value, searchQueryState.value.trim().isNotEmpty()) {
        searchQueryState.value.trim().isNotEmpty()
    }
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current
    val onAction = KeyboardActions{
        if(!valid) return@KeyboardActions
        onSearch(searchQueryState.value.trim())
        searchQueryState.value = ""
        keyboardController?.hide()
    }


    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            WeatherTopBar(
                isMainScreen = false,
                onIcon3Clicked = {
                    navigateBackToMainScreen.invoke()
                },
                border = null,
                title = "Search cities"
            )
        },
        containerColor = Color.White,
        contentColor = Color.Black
    ) { it ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = onAction,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    cursorColor = Color.LightGray,
                    focusedTextColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray,
                    disabledTextColor = Color.LightGray
                ),
                shape = RoundedCornerShape(15.dp),
                singleLine = true,
                value = searchQueryState.value,
                onValueChange = {
                    searchQueryState.value = it
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp
                    ),
                label = {
                    Text(
                        text = "Search...",
                        color = Color.LightGray
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.LightGray
                    )
                }
            )
        }
    }
}