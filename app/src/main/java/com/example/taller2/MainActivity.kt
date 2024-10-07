package com.example.taller2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.taller2.ui.theme.Taller2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller2Theme {
                var greeting by remember { mutableStateOf("Cargando...") }

                // Iniciar el hilo para obtener el saludo
                GreetingThread { newGreeting ->
                    runOnUiThread {
                        greeting = newGreeting
                    }
                }.start()

                PantallaInicio(greeting = greeting, onContinueClicked = {
                    // Lógica para continuar a la pantalla principal
                })
            }
        }
    }
}