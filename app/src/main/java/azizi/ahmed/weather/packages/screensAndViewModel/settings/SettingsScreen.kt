package azizi.ahmed.weather.packages.screensAndViewModel.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import azizi.ahmed.weather.packages.components.common.WeatherTopBar
import azizi.ahmed.weather.packages.model.UnitEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    settingsViewModel: UnitsViewModel = hiltViewModel()
) {
    val dismiss = remember {
        mutableStateOf(false)
    }

    val listOfUnits = remember {
        mutableStateListOf("Imperial (F)", "Metric (C)")
    }

    val choiceFromDB = settingsViewModel.unitList.collectAsState().value

    val defaultChoice = if(choiceFromDB.isEmpty()) listOfUnits[1] else choiceFromDB[0].unit

    val unitChoice = remember {
        mutableStateOf(defaultChoice)
    }

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
                title = "Setting",
                navController = navController
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
                text = "Chane Units of Measurement",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(10.dp),
                color = Color.DarkGray
            )
            Card(
                modifier = modifier
                    .padding(10.dp)
                    .height(60.dp)
                    .width(170.dp),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.DarkGray
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .clickable {
                            dismiss.value = !dismiss.value
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = unitChoice.value,
                        modifier = modifier.padding(10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (dismiss.value) {
                    BasicAlertDialog(
                        onDismissRequest = {
                            dismiss.value = !dismiss.value
                        }
                    ) {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color.White
                                )
                                .padding(
                                    end = 60.dp
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            DropdownMenu(
                                expanded = true,
                                onDismissRequest = {
                                    dismiss.value = !dismiss.value
                                },
                                containerColor = Color.White,
                                modifier = modifier.height(100.dp).width(200.dp)
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = listOfUnits[0],
                                            fontSize = 20.sp
                                        )
                                    },
                                    onClick = {
                                        dismiss.value = !dismiss.value
                                        unitChoice.value = listOfUnits[0]
                                        settingsViewModel.deleteAllUnits()
                                        settingsViewModel.insertUnit(
                                            UnitEntity(
                                                unit = unitChoice.value
                                            )
                                        )
                                        navController.popBackStack()
                                    },
                                    colors = MenuDefaults.itemColors(
                                        textColor = Color.DarkGray
                                    ),
                                    modifier = modifier.fillMaxWidth()
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = listOfUnits[1],
                                            fontSize = 20.sp
                                        )
                                    },
                                    onClick = {
                                        dismiss.value = !dismiss.value
                                        unitChoice.value = listOfUnits[1]
                                        settingsViewModel.deleteAllUnits()
                                        settingsViewModel.insertUnit(
                                            UnitEntity(
                                                unit = unitChoice.value
                                            )
                                        )
                                        navController.popBackStack()
                                    },
                                    colors = MenuDefaults.itemColors(
                                        textColor = Color.DarkGray
                                    ),
                                    modifier = modifier.fillMaxWidth(),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}