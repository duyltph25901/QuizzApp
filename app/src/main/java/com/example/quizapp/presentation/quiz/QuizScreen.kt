package com.example.quizapp.presentation.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.presentation.quiz.components.QuizAppBar
import com.example.quizapp.ui.theme.QuizAppTheme

@Composable
fun QuizScreen(
    numberOfQuiz: Int,
    quizCategory: String,
    quizDiff: String,
    quizType: String,
    event: (EventQuizScreen) -> Unit,
    state: StateQuizScreen
) {

    val context = LocalContext.current
    LaunchedEffect(
        key1 = Unit
    ) {
        event(
            EventQuizScreen.GetQuizzes(
                amount = numberOfQuiz,
                category = quizCategory,
                diff = when (quizDiff) {
                    context.getString(R.string.itemDifficultly1) -> "easy"
                    context.getString(R.string.itemDifficultly2) -> "medium"
                    else -> "hard"
                },
                type = when (quizType) {
                    context.getString(R.string.itemType1) -> "multiple"
                    else -> "boolean"
                }
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
                .background(
                    color = colorResource(R.color.mid_night_blue)
                )
        ) {
            QuizAppBar(
                category = quizCategory,
                onEventIconBack = {

                }
            )

            SpaceHeight(dp = 16.dp)

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 12.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${stringResource(R.string.question)}: $numberOfQuiz",
                    color = Color.White,
                    fontSize = 12.sp
                )

                Text(
                    text = quizDiff,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }

            SpaceHeight(dp = 4.dp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        height = 2.dp
                    )
                    .padding(
                        horizontal = 12.dp,
                    )
                    .clip(
                        shape = RoundedCornerShape(
                            size = 1.dp
                        )
                    )
                    .background(
                        color = colorResource(
                            id = R.color.blue_grey
                        )
                    )
            )

            SpaceHeight(dp = 16.dp)

            // Quiz interface

        }
    }
}

@Composable
private fun SpaceHeight(dp: Dp = 12.dp) {
    Spacer(
        modifier = Modifier.height(
            height = dp
        )
    )
}

/*
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
}*/
