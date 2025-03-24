package com.example.quizapp.presentation.nav_graph

import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_CATEGORY
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_DIFFICULTY
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_NUMBER
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_TYPE

sealed class Routes(
    val route: String
) {

    data object HomeScreen : Routes(route = "home_screen")
    data object QuizScreen: Routes(
        route = "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"
    ) {
        fun passQuizParams(
            numberOfQuiz: Int,
            category: String,
            diff: String,
            type: String
        ) =
            "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"
                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_NUMBER}",
                    newValue = numberOfQuiz.toString()
                )
                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_CATEGORY}",
                    newValue = category
                )
                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_DIFFICULTY}",
                    newValue = diff
                )
                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_TYPE}",
                    newValue = type
                )
    }

    data object ScoreScreen : Routes(
        route = "score_screen"
    )

}