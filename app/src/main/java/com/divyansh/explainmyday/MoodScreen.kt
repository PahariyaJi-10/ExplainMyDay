package com.divyansh.explainmyday

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divyansh.explainmyday.ui.theme.TextPrimary

@Composable
fun MoodScreen(
    onMoodSelected: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "How was your mood today?",
            color = TextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        MoodOption("😊 Good", onMoodSelected)
        MoodOption("😐 Neutral", onMoodSelected)
        MoodOption("😔 Low", onMoodSelected)
    }
}

@Composable
fun MoodOption(
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )
    }
}
