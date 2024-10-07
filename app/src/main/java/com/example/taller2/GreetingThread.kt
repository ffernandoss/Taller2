package com.example.taller2


import java.util.Calendar

class GreetingThread(private val updateGreeting: (String) -> Unit) : Thread() {
    override fun run() {
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val greetingText = when (currentHour) {
            in 0..11 -> "Buenos días"
            in 12..17 -> "Buenas tardes"
            else -> "Buenas noches"
        }
        updateGreeting(greetingText)
    }
}