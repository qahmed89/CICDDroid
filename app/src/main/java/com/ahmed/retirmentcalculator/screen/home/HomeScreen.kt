package com.ahmed.retirmentcalculator.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.ahmed.retirmentcalculator.R
import com.ahmed.retirmentcalculator.screen.home.composable.EditTextHome

@Composable
fun HomeScreen(
    state: HomeStateUi,
    onIntent: (HomeIntent) -> Unit
    ) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                EditTextHome(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.monthlySaving,
                    label = stringResource(id = R.string.monthly_saving),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)

                ) {
                    onIntent(HomeIntent.TypingInMonthlySaving(it))
                }
                EditTextHome(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.insertRate,
                    label = stringResource(id = R.string.insert_rate),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)

                ) {
                    onIntent(HomeIntent.TypingInInsertRate(it))
                }
                EditTextHome(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.currentAge,
                    label = stringResource(id = R.string.current_age),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                ) {
                    onIntent(HomeIntent.TypingInCurrentAge(it))
                }
                EditTextHome(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.plannedRetirementAge,
                    label = stringResource(id = R.string.planned_retirement_age),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                ) {
                    onIntent(HomeIntent.TypingInPlannedRetirementAge(it))
                }
                EditTextHome(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.currentSaving,
                    label = stringResource(id = R.string.current_saving),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                ) {
                    onIntent(HomeIntent.TypingInCurrentSaving(it))
                }
                Button(onClick = { onIntent(HomeIntent.ClickOnCalculate) }) {
                    Text(text = stringResource(id = R.string.calculate))
                }
                Text(text = stringResource(id = R.string.message_calculate,state.monthlySaving,state.currentSaving))
            }
        }

    }
}