package com.example.practic1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practic1.ui.theme.Practic1Theme

class Practic6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practic1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        CircleFunction1()
                        Spacer(modifier = Modifier.height(32.dp))
                        CircleFunction2()
                    }
                }
            }
        }
    }
}

@Composable
fun CircleFunction1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
        )
    }
}

@Composable
fun CircleFunction2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(Color.Magenta)
        )
    }
}

@Preview(showBackground = true, name = "Задание 6")
@Composable
fun Practic6Preview() {
    Practic1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                CircleFunction1()
                Spacer(modifier = Modifier.height(32.dp))
                CircleFunction2()
            }
        }
    }
}