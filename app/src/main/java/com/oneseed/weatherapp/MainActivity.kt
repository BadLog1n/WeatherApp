package com.oneseed.weatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.oneseed.weatherapp.screens.MainScreen
import com.oneseed.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    var request = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppTheme {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    FalseResult()
                    requestLocationPermission()
                } else {
                    MainScreen()
                }


            }
        }

    }


    @Composable
    @Preview(showBackground = false)
    fun FalseResult() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Для работы приложения необходимо выдать разрешение на доступ к геолокации",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }


    }


    /**
     * Запрос разрешения на доступ к геолокации
     * */
    private fun requestLocationPermission() {
        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        requestPermissions(permissions, 0)
        request = true
    }


}

