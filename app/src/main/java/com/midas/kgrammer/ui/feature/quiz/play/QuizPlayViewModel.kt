package com.midas.kgrammer.ui.feature.quiz.play

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midas.kgrammer.data.repository.QuizListRepository
import com.midas.kgrammer.ui.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizPlayViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val repository: QuizListRepository
) : ViewModel() {

    var state by mutableStateOf(
        QuizPlayContract.State(
            null, listOf(
            )
        )
    )
        private set

    init {
        viewModelScope.launch {
            val categoryId = stateHandle.get<Long>(NavigationKeys.Arg.QUIZ_ID)
                ?: throw IllegalStateException("No quizId was passed to destination.")
            val quizes = repository.getQuizList()
            val quiz = quizes.first { it.id == categoryId }
            state = state.copy(quiz = quiz)
//            val foodItems = repository.getMealsByCategory(categoryId)
//            state = state.copy(categoryFoodItems = foodItems)
        }
    }

}
