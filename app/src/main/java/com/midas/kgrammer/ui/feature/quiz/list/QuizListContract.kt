package com.midas.kgrammer.ui.feature.quiz.list

import com.midas.kgrammer.data.model.QuizLevel

class QuizListContract {

    data class State(
        val categories: List<QuizLevel> = listOf(),
        val isLoading: Boolean = false
    )

    sealed class Effect {
        object DataWasLoaded : Effect()
    }
}