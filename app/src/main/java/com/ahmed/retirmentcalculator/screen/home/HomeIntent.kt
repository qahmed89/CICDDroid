package com.ahmed.retirmentcalculator.screen.home

sealed interface HomeIntent {
    data class TypingInMonthlySaving(val value:String):HomeIntent
    data class TypingInInsertRate(val value:String):HomeIntent
    data class TypingInCurrentAge(val value:String):HomeIntent
    data class TypingInPlannedRetirementAge(val value:String):HomeIntent
    data class TypingInCurrentSaving(val value:String):HomeIntent

    object ClickOnCalculate : HomeIntent

}