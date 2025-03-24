package com.example.quizapp.domain.usecases

import com.example.quizapp.commons.Resource
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetQuizzesUseCase(
    val quizRepository: QuizRepository
) {

    operator fun invoke(
        amount: Int,
        category: Int,
        diff: String,
        type: String
    ): Flow<Resource<List<Quiz>>> = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(
                data = quizRepository.getQuizzes(
                    amount = amount,
                    category = category,
                    diff = diff,
                    type = type
                )
            ))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}