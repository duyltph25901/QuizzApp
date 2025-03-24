package com.example.quizapp.data.remote.dto

import com.example.quizapp.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
) {
}