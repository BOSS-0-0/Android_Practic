package com.example.practic1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practic1.ui.theme.Practic1Theme

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int = 0
)

class Practic10Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practic1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ShoppingCartScreen()
                }
            }
        }
    }
}

@Composable
fun ShoppingCartScreen() {
    var products by remember {
        mutableStateOf(
            listOf(
                Product(1, "Яблоки", 50),
                Product(2, "Бананы", 80),
                Product(3, "Молоко", 120),
                Product(4, "Хлеб", 45),
                Product(5, "Сыр", 250)
            )
        )
    }

    val totalAmount = products.sumOf { it.price * it.quantity }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Корзина товаров",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) { product ->
                ProductItem(
                    product = product,
                    onAdd = {
                        products = products.map {
                            if (it.id == product.id) it.copy(quantity = it.quantity + 1) else it
                        }
                    },
                    onRemove = {
                        products = products.map {
                            if (it.id == product.id && it.quantity > 0) it.copy(quantity = it.quantity - 1) else it
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Итого:",
                        fontSize = 20.sp
                    )
                    Text(
                        text = "$totalAmount ₽",
                        fontSize = 24.sp,
                        color = Color(0xFF415f91)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (totalAmount > 0) {
                            products = products.map { it.copy(quantity = 0) }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = totalAmount > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (totalAmount > 0) Color(0xFF415f91) else Color.Gray
                    )
                ) {
                    Text(
                        text = "Оформить заказ",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${product.price} ₽",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onRemove,
                    enabled = product.quantity > 0,
                    modifier = Modifier.size(40.dp),
                    contentPadding = ButtonDefaults.ContentPadding,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (product.quantity > 0) Color.Red else Color.LightGray
                    )
                ) {
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = if (product.quantity > 0) Color(0xFF415f91) else Color.LightGray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${product.quantity}",
                        color = if (product.quantity > 0) Color.White else Color.Gray,
                        fontSize = 18.sp
                    )
                }

                Button(
                    onClick = onAdd,
                    modifier = Modifier.size(40.dp),
                    contentPadding = ButtonDefaults.ContentPadding,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    )
                ) {
                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Задание 10")
@Composable
fun Practic10Preview() {
    Practic1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ShoppingCartScreen()
        }
    }
}