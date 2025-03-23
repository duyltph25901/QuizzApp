package com.example.quizapp.presentation.home.controller

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quizapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val _homeState = MutableStateFlow(StateHomeScreen(
        numberOfQuiz = 10,
        category = context.getString(R.string.itemCategories1),
        difficulty = context.getString(R.string.itemDifficultly1),
        type = context.getString(R.string.itemType1)
    ))
    val homeState: Flow<StateHomeScreen> = _homeState

    fun onEvent(event: EventHomeScreen) {
        when (event) {
            is EventHomeScreen.SetNumberOfQuizzes -> {
                _homeState.value =
                    _homeState.value.copy(
                        numberOfQuiz = event.number
                    )
            }

            is EventHomeScreen.SetQuizCategory -> {
                _homeState.value =
                    _homeState.value.copy(
                        category = event.category
                    )
            }

            is EventHomeScreen.SetQuizDifficulty -> {
                _homeState.value =
                    _homeState.value.copy(
                        difficulty = event.diff
                    )
            }

            is EventHomeScreen.SetQuizType -> {
                _homeState.value =
                    _homeState.value.copy(
                        type = event.type
                    )
            }
        }
    }

}