package com.joelkanyi.navigatewithargumentonpopbackstack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.joelkanyi.navigatewithargumentonpopbackstack.navigation.NavigationGraph
import com.joelkanyi.navigatewithargumentonpopbackstack.ui.theme.NavigateWithArgumentOnPopBackStackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigateWithArgumentOnPopBackStackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()

                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
