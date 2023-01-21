package com.oneseed.weatherapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.text.SimpleDateFormat
import java.util.*

@Composable
@Preview(showBackground = false)
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = SimpleDateFormat("dd MMMM", Locale.getDefault()).format(
                            Date()
                        ).toString(),
                        style = TextStyle(fontSize = 15.sp),
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = "London",
                        style = TextStyle(fontSize = 15.sp),
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "4°",
                        style = TextStyle(fontSize = 50.sp),
                        modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.CenterVertically)
                    )
                    AsyncImage(
                        model = "https:////cdn.weatherapi.com/weather/64x64/day/113.png",
                        contentDescription = "im2",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(50.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                Text(
                    text = "Облачно",
                    style = TextStyle(fontSize = 15.sp),
                )
                Text(
                    text = "Ощущается как 4°",
                    style = TextStyle(fontSize = 15.sp),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
        }
    }
}

