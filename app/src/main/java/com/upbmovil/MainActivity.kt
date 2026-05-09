package com.upbmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.upbmovil.screens.HomeScreen
import com.upbmovil.ui.theme.UPBMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UPBMovilTheme {
                HomeScreen()
            }
        }
    }
}
