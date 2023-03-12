package com.midas.kgrammer.data.model

data class QuizItem(
    val id: Long,
    val data: List<QuizData>
)

data class QuizData(
    val answer: String,
    val wrong: String
)