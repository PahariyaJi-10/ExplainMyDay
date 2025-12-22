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
            HomeScreen(
                onExplainClick = {
                    navController.navigate("mood")
                }
            )
        }

        composable("mood") {
            MoodScreen(
                onMoodSelected = {
                    navController.navigate("energy")
                }
            )
        }

        composable("energy") {
            EnergyScreen()
        }
    }
}
