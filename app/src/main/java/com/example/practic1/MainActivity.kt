package com.example.practic1

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
import com.example.practic1.ui.theme.Practic1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practic1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Hello(name = "Никита")
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    val displayText = if (name != null) {
        "Привет, $name!"
    } else {
        "Имя не задано"
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = displayText,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(showBackground = true, name = "С именем")
@Composable
fun HelloPreviewWithName() {
    Practic1Theme {
        Hello(name = "Мария")
    }
}

@Preview(showBackground = true, name = "Без имени (null)")
@Composable
fun HelloPreviewWithNull() {
    Practic1Theme {
        Hello(name = null)
    }
}