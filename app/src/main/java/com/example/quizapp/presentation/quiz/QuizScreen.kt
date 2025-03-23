package com.example.quizapp.presentation.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.presentation.quiz.components.QuizAppBar
import com.example.quizapp.ui.theme.QuizAppTheme

@Composable
fun QuizScreen(
    numberOfQuiz: Int,
    quizCategory: String,
    quizDiff: String
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
        ) {
            QuizAppBar(
                category = quizCategory,
                onEventIconBack = {

                }
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewQuizScreen() {
    QuizAppTheme {
        QuizScreen(
            numberOfQuiz = 10,
            quizCategory = "Gk",
            quizDiff = "Hard"
        )
    }
}