package com.midas.kgrammer.data.repository

import com.midas.kgrammer.data.model.QuizLevel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizListRepository @Inject constructor() {

    fun getQuizList(): List<QuizLevel> {
        return listOf(
            QuizLevel(
                id = 0,
                correctPercent = 100
            ),
            QuizLevel(
                id = 1,
                correctPercent = 50
            ),
            QuizLevel(
                id = 2,
                correctPercent = 0
            ),
            QuizLevel(
                id = 3,
                correctPercent = -1
            ),
            QuizLevel(
                id = 4,
                correctPercent = -1
            ),
            QuizLevel(
                id = 5,
                correctPercent = -1
            ),
            QuizLevel(
                id = 6,
                correctPercent = -1
            )
        )
    }
}