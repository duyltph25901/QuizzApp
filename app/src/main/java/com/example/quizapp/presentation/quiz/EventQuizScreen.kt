package com.example.quizapp.presentation.quiz

sealed class EventQuizScreen {
    data class GetQuizzes(
        val amount: Int,
        val category: String,
        val diff: String,
        val type: String
    ): EventQuizScreen()
}