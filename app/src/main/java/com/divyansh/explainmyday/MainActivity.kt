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

        composable("home") {
            HomeScreen {
                navController.navigate("mood")
            }
        }

        composable("mood") {
            MoodScreen { mood ->
                navController.navigate("energy/$mood")
            }
        }

        composable("energy/{mood}") { backStackEntry ->
            val mood = backStackEntry.arguments?.getString("mood") ?: ""

            EnergyScreen { energy ->
                navController.navigate("productivity/$mood/$energy")
            }
        }

        composable("productivity/{mood}/{energy}") { backStackEntry ->
            val mood = backStackEntry.arguments?.getString("mood") ?: ""
            val energy = backStackEntry.arguments?.getString("energy") ?: ""

            ProductivityScreen { productivity ->
                navController.navigate("result/$mood/$energy/$productivity")
            }
        }

        composable("result/{mood}/{energy}/{productivity}") { backStackEntry ->
            ResultScreen(
                mood = backStackEntry.arguments?.getString("mood") ?: "",
                energy = backStackEntry.arguments?.getString("energy") ?: "",
                productivity = backStackEntry.arguments?.getString("productivity") ?: ""
            )
        }
    }
}
