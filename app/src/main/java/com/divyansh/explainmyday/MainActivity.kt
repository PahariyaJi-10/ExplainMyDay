package com.divyansh.explainmyday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.divyansh.explainmyday.ui.theme.BackgroundDark
import com.divyansh.explainmyday.ui.theme.ExplainMyDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExplainMyDayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundDark
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // HOME
        composable("home") {
            HomeScreen {
                navController.navigate("mood")
            }
        }

        // MOOD
        composable("mood") {
            MoodScreen {
                navController.navigate("energy")
            }
        }

        // ENERGY
        composable("energy") {
            EnergyScreen {
                navController.navigate("productivity")
            }
        }

        // PRODUCTIVITY
        composable("productivity") {
            ProductivityScreen {
                navController.navigate("result")
            }
        }

        // RESULT
        composable("result") {
            ResultScreen(
                mood = "neutral",
                energy = "medium",
                productivity = "medium"
            )
        }
    }
}
