package com.ahmed.retirmentcalculator.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.pow

class HomeViewModel : ViewModel() {

   private val _state = MutableStateFlow(HomeStateUi())
    val state = _state.asStateFlow()

    fun onIntent(intent: HomeIntent){
        when(intent){
            HomeIntent.ClickOnCalculate -> TODO()
            is HomeIntent.TypingInCurrentAge -> _state.update { it.copy(currentAge = intent.value) }
            is HomeIntent.TypingInCurrentSaving -> _state.update { it.copy(currentSaving = intent.value) }
            is HomeIntent.TypingInInsertRate -> _state.update { it.copy(insertRate = intent.value) }
            is HomeIntent.TypingInMonthlySaving -> _state.update { it.copy(monthlySaving = intent.value) }
            is HomeIntent.TypingInPlannedRetirementAge -> _state.update { it.copy(plannedRetirementAge = intent.value) }
        }
    }


}