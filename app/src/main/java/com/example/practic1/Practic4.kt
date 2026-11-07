package com.example.practic1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practic1.ui.theme.Practic1Theme

class Practic4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practic1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    StyledButtonScreen()
                }
            }
        }
    }
}

@Composable
fun StyledButtonScreen() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Нажми меня",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true, name = "Задание 4")
@Composable
fun Practic4Preview() {
    Practic1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            StyledButtonScreen()
        }
    }
}