package com.example.quizapp.di

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.data.repository.QuizRepositoryImpl
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.usecases.GetQuizzesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Singleton
    @Provides
    fun providesGetQuizzesUseCase(
        repo: QuizRepository
    ): GetQuizzesUseCase =
        GetQuizzesUseCase(repo)

}