package com.oneseed.weatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
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
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.oneseed.weatherapp.screens.MainScreen
import com.oneseed.weatherapp.ui.theme.WeatherAppTheme

const val API_KEY = "5c1cd77850cf46a6b41154108231901"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppTheme {
                getData(36.18557739257813, 51.74756622314453)

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
    }



    private fun getData(longitude: Double, latitude: Double) {
        val url =
            "https://api.weatherapi.com/v1/forecast.json?" +
                    "key=$API_KEY" +
                    " &q=$latitude,$longitude" +
                    "&days=1" +
                    "&aqi=no" +
                    "&alerts=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                Log.d("TAG", "Response is: ${response.substring(0, 500)}")
            },
            { Log.d("TAG", "That didn't work!") })
        queue.add(stringRequest)
    }
}

