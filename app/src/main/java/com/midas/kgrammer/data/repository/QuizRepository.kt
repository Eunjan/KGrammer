package com.midas.kgrammer.data.repository

import com.midas.kgrammer.data.model.QuizData
import com.midas.kgrammer.data.model.QuizItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizRepository @Inject constructor() {

    private val list = listOf(
        QuizItem(
            id = 0,
            data = listOf(
                QuizData(
                    answer = "덤터기",
                    wrong = "덤테기"
                ),
                QuizData(
                    answer = "그러든 말든",
                    wrong = "그러던 말던"
                ),
                QuizData(
                    answer = "대물림",
                    wrong = "되물림"
                ),
                QuizData(
                    answer = "굳이",
                    wrong = "구지"
                ),
                QuizData(
                    answer = "간질이지 마",
                    wrong = "간지르지 마"
                )
            )
        ),
        QuizItem(
            id = 1,
            data = listOf(
                QuizData(
                    answer = "괴팍하다",
                    wrong = "괴퍅하다"
                ),
                QuizData(
                    answer = "재작년",
                    wrong = "제작년"
                ),
                QuizData(
                    answer = "사기충천",
                    wrong = "사기충전"
                ),
                QuizData(
                    answer = "차지다",
                    wrong = "찰지다"
                ),
                QuizData(
                    answer = "뇌졸중",
                    wrong = "뇌졸증"
                )
            )
        ),
    )

    fun getQuiz(id: Long) = list.find {
        it.id == id
    }
}