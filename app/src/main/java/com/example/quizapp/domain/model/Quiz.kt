package com.example.quizapp.domain.model

data class Quiz(
    val category: String,
    val correct_answer: String,
    val difficultly: String,
    val incorrect_answer: List<String>,
    val question: String,
    val type: String
) {
}