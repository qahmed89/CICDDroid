package com.ahmed.retirmentcalculator.screen.home.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditTextHome(
    modifier: Modifier = Modifier,
    text: String,
    label :String,
    keyboardOptions: KeyboardOptions,
    onTextChanged : (String)->Unit,
) {
    TextField(
        keyboardOptions = keyboardOptions,
        value = text, onValueChange = onTextChanged,label={
        Text(label)
    }, modifier = modifier)
}