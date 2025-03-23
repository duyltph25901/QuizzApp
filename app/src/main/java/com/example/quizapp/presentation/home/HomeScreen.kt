package com.example.quizapp.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizapp.R
import com.example.quizapp.presentation.common.ListMenu.getListCategories
import com.example.quizapp.presentation.common.ListMenu.getListDifficultly
import com.example.quizapp.presentation.common.ListMenu.getListNumberOfQuestions
import com.example.quizapp.presentation.common.ListMenu.getListType
import com.example.quizapp.presentation.home.components.AppDropMenu
import com.example.quizapp.presentation.home.components.BtnBox
import com.example.quizapp.presentation.home.components.HomeHeader
import com.example.quizapp.presentation.home.controller.EventHomeScreen
import com.example.quizapp.presentation.home.controller.HomeViewModel
import com.example.quizapp.presentation.home.controller.StateHomeScreen

@Composable
fun HomeScreen(
    stateHomeScreen: StateHomeScreen,
    event: (EventHomeScreen) -> Unit
) {
    val context = LocalContext.current


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
                .verticalScroll(rememberScrollState())
                .background(
                    color = colorResource(R.color.mid_night_blue)
                )
        ) {
            HomeHeader()

            Spacer8Dp(customDp = 24.dp)
            AppDropMenu(
                menuName = stringResource(R.string.menuName1),
                menuList = getListNumberOfQuestions(),
                text = stateHomeScreen.numberOfQuiz.toString()
            ) { item ->
                event.invoke(
                    EventHomeScreen.SetNumberOfQuizzes(
                        number = item.toInt()
                    )
                )
            }

            Spacer8Dp()
            AppDropMenu(
                menuName = stringResource(R.string.menuName2),
                menuList = getListCategories(context),
                stateHomeScreen.category
            ) { item ->
                event.invoke(
                    EventHomeScreen.SetQuizCategory(
                        category = item
                    )
                )
            }

            Spacer8Dp()
            AppDropMenu(
                menuName = stringResource(R.string.menuName3),
                menuList = getListDifficultly(context),
                text = stateHomeScreen.difficulty
            ) { item ->
                event.invoke(
                    EventHomeScreen.SetQuizDifficulty(
                        diff = item
                    )
                )
            }

            Spacer8Dp()
            AppDropMenu(
                menuName = stringResource(R.string.menuName4),
                menuList = getListType(context),
                text = stateHomeScreen.type
            ) { item ->
                event.invoke(
                    EventHomeScreen.SetQuizType(
                        type = item
                    )
                )
            }

            Spacer8Dp(customDp = 24.dp)
            BtnBox(
                textValue = stringResource(R.string.btn_gen_quiz),
                onEventGenerateQuiz = {
                    eventGenerateQuiz(
                        numberOfQuiz = stateHomeScreen.numberOfQuiz,
                        category = stateHomeScreen.category,
                        diff = stateHomeScreen.difficulty,
                        type = stateHomeScreen.type
                    )
                }
            )
        }
    }
}

@Composable
private fun Spacer8Dp(customDp: Dp = 8.dp) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                height = customDp
            )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        stateHomeScreen = StateHomeScreen(),
        event = {}
    )
}

private fun eventGenerateQuiz(
    numberOfQuiz: Int,
    category: String,
    diff: String,
    type: String
) {
    Log.d("duylt", "Number Of Quiz: ${numberOfQuiz}\nCategory: ${category}\nDiff: ${diff}\nType: $type")
}