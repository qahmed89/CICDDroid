package com.ahmed.retirmentcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahmed.retirmentcalculator.screen.home.HomeScreen
import com.ahmed.retirmentcalculator.screen.home.HomeStateUi
import com.ahmed.retirmentcalculator.screen.home.HomeViewModel
import com.ahmed.retirmentcalculator.ui.theme.RetirmentCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetirmentCalculatorTheme {
                val viewModel :HomeViewModel by viewModels()
                val state : HomeStateUi by viewModel.state.collectAsState()
                HomeScreen(state = state , onIntent = viewModel::onIntent)

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetirmentCalculatorTheme {
        Greeting("Android")
    }
}