package com.example.clicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clicker.ui.theme.ClickerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen("player1")
                }
            }
        }
    }
}

@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    val count = remember { mutableStateOf(0) } // Initialize the counter state

    Surface(color = Color.White) {
        Column {
            Text(
                text = "Hello, $name!",
                modifier = modifier.padding(24.dp)
            )
            Text(
                text = "Tap the button to play",
                modifier = modifier.padding(24.dp)
            )
            Text(
                text = "Counter: ${count.value}", // Display the counter
                modifier = modifier.padding(24.dp)
            )
            ButtonExample(count) // Pass the state to the button
        }
    }
}

@Composable
fun ButtonExample(count: androidx.compose.runtime.MutableState<Int>) {
    Column {
        Button(
            onClick = { count.value++ }, // Increment the counter when clicked
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(24.dp).width(120.dp).height(40.dp)
        ) {
            Text("button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickerTheme {
        MainScreen("player1")
    }
}