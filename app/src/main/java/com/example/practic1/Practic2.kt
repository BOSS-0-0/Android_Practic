package com.example.practic1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class Practic2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Practic2Screen()
                }
            }
        }
    }
}

@Composable
fun Practic2Screen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Задание 2: Три макета",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Portrait",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewPortrait() {
    MaterialTheme {
        Practic2Screen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Landscape",
    widthDp = 400,
    heightDp = 200
)
@Composable
fun PreviewLandscape() {
    MaterialTheme {
        Practic2Screen()
    }
}


@Preview(
    showBackground = true,
    name = "Round",
    widthDp = 200,
    heightDp = 200,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp"
)
@Composable
fun PreviewRound() {
    MaterialTheme {
        Practic2Screen()
    }
}