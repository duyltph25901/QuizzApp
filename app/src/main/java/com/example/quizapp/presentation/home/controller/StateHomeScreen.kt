package com.example.quizapp.presentation.home.controller

data class StateHomeScreen(
    val numberOfQuiz: Int = 10,
    val category: String = "",
    val difficulty: String = "",
    val type: String = ""
) {
}