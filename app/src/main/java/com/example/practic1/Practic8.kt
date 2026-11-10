package com.example.practic1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practic1.ui.theme.Practic1Theme

class Practic8Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practic1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WaterTrackerScreen()
                }
            }
        }
    }
}

@Composable
fun WaterTrackerScreen() {
    var waterCount by remember { mutableIntStateOf(0) }
    var daysCount by remember { mutableIntStateOf(0) }

    val primaryColor = Color(0xFF415f91)
    val secondaryColor = Color(0xFF565f71)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Дней подряд (1500+ мл): $daysCount",
            fontSize = 18.sp,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { waterCount += 250 },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
        ) {
            Text(text = "+250 мл", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (waterCount >= 1500) {
                    daysCount++
                } else {
                    daysCount = 0
                }
                waterCount = 0
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Завершить день", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true, name = "Задание 8")
@Composable
fun Practic8Preview() {
    Practic1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            WaterTrackerScreen()
        }
    }
}