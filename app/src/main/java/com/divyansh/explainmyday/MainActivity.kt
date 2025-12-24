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
            HomeScreen(
                onExplainClick = {
                    navController.navigate("mood")
                }
            )
        }

        // MOOD
        composable("mood") {
            MoodScreen(
                onMoodSelected = { mood ->
                    navController.navigate("energy/$mood")
                }
            )
        }

        // ENERGY
        composable("energy/{mood}") { backStackEntry ->
            val mood = backStackEntry.arguments?.getString("mood") ?: ""

            EnergyScreen(
                onEnergySelected = { energy ->
                    navController.navigate("productivity/$mood/$energy")
                }
            )
        }

        // PRODUCTIVITY
        composable("productivity/{mood}/{energy}") { backStackEntry ->
            val mood = backStackEntry.arguments?.getString("mood") ?: ""
            val energy = backStackEntry.arguments?.getString("energy") ?: ""

            ProductivityScreen(
                onProductivitySelected = { productivity ->
                    navController.navigate("result/$mood/$energy/$productivity")
                }
            )
        }

        // RESULT (⚠️ THIS IS THE KEY FIX)
        composable("result/{mood}/{energy}/{productivity}") { backStackEntry ->
            val mood = backStackEntry.arguments?.getString("mood") ?: ""
            val energy = backStackEntry.arguments?.getString("energy") ?: ""
            val productivity = backStackEntry.arguments?.getString("productivity") ?: ""

            ResultScreen(
                mood = mood,
                energy = energy,
                productivity = productivity
            )
        }
    }
}
