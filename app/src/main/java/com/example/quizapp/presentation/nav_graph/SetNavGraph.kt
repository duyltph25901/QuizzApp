package com.example.quizapp.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.quizapp.R
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_CATEGORY
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_DIFFICULTY
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_NUMBER
import com.example.quizapp.commons.AppConst.ARG_KEY_QUIZ_TYPE
import com.example.quizapp.presentation.home.controller.HomeViewModel
import com.example.quizapp.presentation.home.controller.StateHomeScreen
import com.example.quizapp.presentation.main_activity.MainScreen
import com.example.quizapp.presentation.quiz.QuizScreen
import com.example.quizapp.presentation.quiz.QuizViewModel
import com.example.quizapp.presentation.quiz.StateQuizScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@Composable
fun SetNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route,
    ) {

        // Home Screen
        composable(
            route = Routes.HomeScreen.route
        ) {
            val vm: HomeViewModel = hiltViewModel()
            val state by vm.homeState.collectAsState(
                initial = StateHomeScreen(
                    numberOfQuiz = 10,
                    category = context.getString(R.string.itemCategories1),
                    difficulty = context.getString(R.string.itemDifficultly1),
                    type = context.getString(R.string.itemType1)
                ),
                context = Dispatchers.Main
            )
            MainScreen(
                stateHomeScreen = state,
                event = vm::onEvent,
                navController
            )
        }


        // Quiz Screen
        composable(
            route = Routes.QuizScreen.route,
            arguments = listOf(
                navArgument(ARG_KEY_QUIZ_NUMBER) {
                    type = NavType.IntType
                },
                navArgument(ARG_KEY_QUIZ_CATEGORY) {
                    type = NavType.StringType
                },
                navArgument(ARG_KEY_QUIZ_DIFFICULTY) {
                    type = NavType.StringType
                },
                navArgument(ARG_KEY_QUIZ_TYPE) {
                    type = NavType.StringType
                }
            ),
        ) {
            val numberOfQuiz = it.arguments?.getInt(ARG_KEY_QUIZ_NUMBER, 0) ?: 0
            val category = it.arguments?.getString(ARG_KEY_QUIZ_CATEGORY, "") ?: ""
            val diff = it.arguments?.getString(ARG_KEY_QUIZ_DIFFICULTY, "") ?: ""
            val type = it.arguments?.getString(ARG_KEY_QUIZ_TYPE, "") ?: ""

            val quizViewModel: QuizViewModel = hiltViewModel()
            val state by quizViewModel.quizList.collectAsState(
                initial = StateQuizScreen(),
                context = Dispatchers.Main + Job()
            )

            QuizScreen(
                numberOfQuiz = numberOfQuiz,
                quizCategory = category,
                quizDiff = diff,
                quizType = type,
                state = state,
                event = quizViewModel::onEvent
            )
        }
    }
}