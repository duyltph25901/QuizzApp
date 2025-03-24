package com.example.quizapp.presentation.quiz

import com.example.quizapp.domain.model.Quiz

data class StateQuizScreen(
    val isLoading: Boolean = false,
    val data: List<Quiz>? = listOf(),
    val error: String = ""
) {
}