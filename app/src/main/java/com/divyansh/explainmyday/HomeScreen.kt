package com.divyansh.explainmyday

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divyansh.explainmyday.ui.theme.PrimaryBlue
import com.divyansh.explainmyday.ui.theme.TextPrimary
import com.divyansh.explainmyday.ui.theme.TextSecondary

@Composable
fun HomeScreen(
    onExplainClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Explain My Day",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your daily reflection✨",
            fontSize = 14.sp,
            color = TextSecondary

        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onExplainClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Explain My Day",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

