package com.ahmed.retirmentcalculator.screen.home

import androidx.lifecycle.ViewModel
import com.microsoft.appcenter.analytics.Analytics
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeStateUi())
    val state = _state.asStateFlow()

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.ClickOnCalculate -> {
                val proprieties = mapOf(
                    "insertRate" to state.value.insertRate,
                    "monthlySaving" to state.value.monthlySaving,
                    "currentAge" to state.value.currentAge,
                    "plannedRetirementAge" to state.value.plannedRetirementAge,
                    "currentSaving" to state.value.currentSaving,
                )
                if (state.value.insertRate.toInt() <= 0) {
                    Analytics.trackEvent("Wrong InsertRate", proprieties)
                }
                if (state.value.currentAge.toInt() <= 0) {
                    Analytics.trackEvent("Wrong Current Age", proprieties)
                }
            }

            is HomeIntent.TypingInCurrentAge -> _state.update { it.copy(currentAge = intent.value) }
            is HomeIntent.TypingInCurrentSaving -> _state.update { it.copy(currentSaving = intent.value) }
            is HomeIntent.TypingInInsertRate -> _state.update { it.copy(insertRate = intent.value) }
            is HomeIntent.TypingInMonthlySaving -> _state.update { it.copy(monthlySaving = intent.value) }
            is HomeIntent.TypingInPlannedRetirementAge -> _state.update {
                it.copy(
                    plannedRetirementAge = intent.value
                )
            }
        }
    }


}