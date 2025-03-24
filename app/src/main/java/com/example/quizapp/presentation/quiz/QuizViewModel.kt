package com.example.quizapp.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.commons.Resource
import com.example.quizapp.domain.usecases.GetQuizzesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuizzesUseCase: GetQuizzesUseCase
) : ViewModel() {

    private val _quizList = MutableStateFlow(StateQuizScreen())
    val quizList: Flow<StateQuizScreen> = _quizList

    fun onEvent(event: EventQuizScreen) {
        when (event) {
            is EventQuizScreen.GetQuizzes -> {
                getQuizzes(
                    amount = event.amount,
                    category = 17,
                    diff = event.diff,
                    type = event.type
                )
            }
        }
    }

    private fun getQuizzes(
        amount: Int,
        category: Int,
        diff: String,
        type: String
    ) {
        viewModelScope.launch {
            getQuizzesUseCase(
                amount = amount,
                category = category,
                diff = diff,
                type = type
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _quizList.value =
                            StateQuizScreen(
                                isLoading = true
                            )
                    }

                    is Resource.Success -> {
                        _quizList.value = StateQuizScreen(
                            data = resource.data
                        )

                        resource.data?.forEach { item ->
                            Log.d("duylt", "Check Item Question: $item")
                        }
                    }

                    is Resource.Error -> {
                        _quizList.value = StateQuizScreen(
                            error = resource.message ?: "Something went wrong!"
                        )
                    }
                }
            }
        }
    }

}