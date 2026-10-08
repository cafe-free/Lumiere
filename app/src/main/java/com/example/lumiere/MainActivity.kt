package com.example.lumiere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.lumiere.ui.screens.MainShowcaseApp
import com.example.lumiere.ui.theme.BackgroundCanvas
import com.example.lumiere.ui.theme.LumiereTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumiereTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundCanvas
                ) {
                    MainShowcaseApp()
                }
            }
        }
    }
}
