package com.midas.kgrammer.ui.feature.quiz.play

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.midas.kgrammer.ui.feature.quiz.list.QuizListContract
import kotlinx.coroutines.flow.Flow

@Composable
fun QuizPlayScreen(
    state: QuizPlayContract.State
) {
    Text(text =  state.quizItem?.id.toString())

}

