package com.example.quizapp.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizapp.R
import com.example.quizapp.presentation.home.HomeScreen
import com.example.quizapp.presentation.home.controller.EventHomeScreen
import com.example.quizapp.presentation.home.controller.HomeViewModel
import com.example.quizapp.presentation.home.controller.StateHomeScreen
import com.example.quizapp.ui.theme.QuizAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                val vm: HomeViewModel = hiltViewModel()
                val state by vm.homeState.collectAsState(
                    initial = StateHomeScreen(
                        numberOfQuiz = 10,
                        category = getString(R.string.itemCategories1),
                        difficulty = getString(R.string.itemDifficultly1),
                        type = getString(R.string.itemType1)
                    ),
                    context = Dispatchers.Main
                )
                MainScreen(
                    stateHomeScreen = state,
                    event = vm::onEvent
                )
            }
        }
    }
}

@Composable
private fun MainScreen(
    stateHomeScreen: StateHomeScreen,
    event: (EventHomeScreen) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HomeScreen(
            stateHomeScreen = stateHomeScreen,
            event = event
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    QuizAppTheme {
        MainScreen(
            stateHomeScreen = StateHomeScreen(),
            event = {}
        )
    }
}