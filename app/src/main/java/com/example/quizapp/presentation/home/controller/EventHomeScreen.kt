package com.example.quizapp.presentation.home.controller

sealed class EventHomeScreen {

    data class SetNumberOfQuizzes(val number: Int): EventHomeScreen()
    data class SetQuizCategory(val category: String): EventHomeScreen()
    data class SetQuizDifficulty(val diff: String): EventHomeScreen()
    data class SetQuizType(val type: String): EventHomeScreen()

}