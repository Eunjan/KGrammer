package com.midas.kgrammer.ui.feature.quiz.play

import com.midas.kgrammer.data.model.QuizLevel

class QuizPlayContract {
    data class State(
        val quiz: QuizLevel?,
        val categoryFoodItems: List<QuizLevel>
    )
}