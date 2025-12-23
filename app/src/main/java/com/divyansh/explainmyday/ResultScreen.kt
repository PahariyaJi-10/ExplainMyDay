package com.divyansh.explainmyday

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divyansh.explainmyday.ui.theme.TextPrimary
import com.divyansh.explainmyday.ui.theme.TextSecondary

@Composable
fun ResultScreen(
    mood: String,
    energy: String,
    productivity: String
) {
    val resultText = getResultText(mood, energy, productivity)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Here’s how your day went",
            color = TextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resultText,
            color = TextSecondary,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )
    }
}

fun getResultText(
    mood: String,
    energy: String,
    productivity: String
): String {

    // 🌤️ MOOD = GOOD
    if (mood == "good" && energy == "high" && productivity == "high")
        return "You felt good, had strong energy, and stayed highly productive.\nToday flowed well — carry this momentum forward."

    if (mood == "good" && energy == "high" && productivity == "medium")
        return "You were in a good mood with plenty of energy and steady productivity.\nA solid, balanced day overall."

    if (mood == "good" && energy == "high" && productivity == "low")
        return "You felt good and energized, even if productivity stayed low.\nNot every energetic day needs to be busy."

    if (mood == "good" && energy == "medium" && productivity == "high")
        return "A good mood and balanced energy helped you stay productive.\nYou made the most of what you had."

    if (mood == "good" && energy == "medium" && productivity == "medium")
        return "You felt good, with steady energy and moderate productivity.\nA calm, well-handled day."

    if (mood == "good" && energy == "medium" && productivity == "low")
        return "Your mood was positive, even if energy and productivity were limited.\nThat’s still a meaningful day."

    if (mood == "good" && energy == "low" && productivity == "high")
        return "Even with low energy, you stayed productive and positive.\nThat shows quiet strength."

    if (mood == "good" && energy == "low" && productivity == "medium")
        return "You felt good despite low energy and moderate effort.\nSlow days can still feel okay."

    if (mood == "good" && energy == "low" && productivity == "low")
        return "You felt good, even though energy and productivity were low.\nRest mattered more today — and that’s fine."

    // 🌿 MOOD = NEUTRAL
    if (mood == "neutral" && energy == "high" && productivity == "high")
        return "You felt steady, energized, and productive.\nEven without strong emotions, you showed up well."

    if (mood == "neutral" && energy == "high" && productivity == "medium")
        return "A neutral mood with good energy and steady productivity.\nNot remarkable — but reliable."

    if (mood == "neutral" && energy == "high" && productivity == "low")
        return "You had energy, though productivity stayed low.\nSome days are more about presence than output."

    if (mood == "neutral" && energy == "medium" && productivity == "high")
        return "With balanced energy and focus, you stayed productive today.\nQuiet progress still counts."

    if (mood == "neutral" && energy == "medium" && productivity == "medium")
        return "Today felt neutral, with balanced energy and moderate effort.\nNot every day needs to stand out."

    if (mood == "neutral" && energy == "medium" && productivity == "low")
        return "A steady day with limited productivity.\nThat’s okay — maintaining balance is progress too."

    if (mood == "neutral" && energy == "low" && productivity == "high")
        return "Despite low energy, you managed to stay productive.\nThat took determination."

    if (mood == "neutral" && energy == "low" && productivity == "medium")
        return "You felt neutral, with low energy and modest effort.\nYou did what you could."

    if (mood == "neutral" && energy == "low" && productivity == "low")
        return "Today was quiet and low-energy.\nRest and stillness were enough."

    // 🌧️ MOOD = LOW
    if (mood == "low" && energy == "high" && productivity == "high")
        return "Even with a low mood, you stayed energized and productive.\nThat took real strength."

    if (mood == "low" && energy == "high" && productivity == "medium")
        return "Your mood was low, but you kept moving forward.\nThat matters more than it feels."

    if (mood == "low" && energy == "high" && productivity == "low")
        return "You had energy, even if productivity didn’t follow.\nEmotional weight can slow things down."

    if (mood == "low" && energy == "medium" && productivity == "high")
        return "Despite feeling low, you stayed productive.\nThat’s resilience."

    if (mood == "low" && energy == "medium" && productivity == "medium")
        return "Today felt heavy, but you managed with what you had.\nYou didn’t stop — and that matters."

    if (mood == "low" && energy == "medium" && productivity == "low")
        return "Your mood and productivity were low today.\nIt’s okay to pause and breathe."

    if (mood == "low" && energy == "low" && productivity == "high")
        return "Even with low mood and energy, you pushed through.\nThat’s not easy — be gentle with yourself."

    if (mood == "low" && energy == "low" && productivity == "medium")
        return "Today was hard, and effort felt limited.\nYou still showed up in your own way."

    if (mood == "low" && energy == "low" && productivity == "low")
        return "Today was difficult.\nYou did what you could — and that is enough for today."

    return "Your day was unique.\nThank you for taking a moment to reflect."
}
