package com.joelkanyi.navigatewithargumentonpopbackstack.screen

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TakeWaterScreen(
    navController: NavController,
) {
    var takenWater by remember {
        mutableStateOf(true)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "takenWater",
                            takenWater,
                        )
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                        )
                    }
                },
                title = {
                    Text(text = "Take Water")
                },
            )
        },
    ) {
        BackHandler {
            navController.previousBackStackEntry?.savedStateHandle?.set(
                "takenWater",
                takenWater,
            )
            navController.popBackStack()
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val radioOptions = listOf("Yes", "No")
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                radioOptions.forEach { text ->
                    Row(
                        Modifier.padding(horizontal = 4.dp),
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            modifier = Modifier
                                .size(24.dp),
                            onClick = {
                                onOptionSelected(text)
                                takenWater = text == "Yes"
                            },
                        )

                        Text(text = text)
                    }
                }
            }
        }
    }
}
