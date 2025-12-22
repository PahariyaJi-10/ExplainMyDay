package com.divyansh.explainmyday

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divyansh.explainmyday.ui.theme.BackgroundDark
import com.divyansh.explainmyday.ui.theme.TextPrimary

@Composable
fun EnergyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "How energetic did you feel today?",
            color = TextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        EnergyOption("🔋 High")
        EnergyOption("🔋 Medium")
        EnergyOption("🔋 Low")
    }
}

@Composable
fun EnergyOption(text: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = BackgroundDark
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                // Next: navigate to productivity
            }
    ) {
        Text(
            text = text,
            color = TextPrimary,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
