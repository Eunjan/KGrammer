package com.midas.kgrammer.ui.feature.quiz.play

import com.midas.kgrammer.data.model.QuizItem
import com.midas.kgrammer.data.model.QuizLevel

class QuizPlayContract {
    data class State(
        val quizItem: QuizItem?
    )
}