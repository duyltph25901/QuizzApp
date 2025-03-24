package com.example.quizapp.data.repository

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.repository.QuizRepository

class QuizRepositoryImpl(
    private val quizApi: QuizApi
) : QuizRepository {
    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        diff: String,
        type: String
    ): List<Quiz> =
        quizApi.getQuizzes(
            amount = amount,
            category = category,
            diff = diff,
            type = type
        ).results
}