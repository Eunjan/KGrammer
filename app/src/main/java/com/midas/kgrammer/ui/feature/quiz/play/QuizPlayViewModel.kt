package com.midas.kgrammer.ui.feature.quiz.play

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midas.kgrammer.data.model.QuizItem
import com.midas.kgrammer.data.repository.QuizListRepository
import com.midas.kgrammer.data.repository.QuizRepository
import com.midas.kgrammer.ui.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizPlayViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val repository: QuizRepository
) : ViewModel() {

    var state by mutableStateOf(
        QuizPlayContract.State(
            null
        )
    )
        private set

    init {
        viewModelScope.launch {
            val quizId = stateHandle.get<Long>(NavigationKeys.Arg.QUIZ_ID)
                ?: throw IllegalStateException("No quizId was passed to destination.")
            val quiz = repository.getQuiz(quizId)
            quiz?.let {
                state = state.copy(quizItem = QuizItem(
                    id = quizId,
                    data = it.data.shuffled()
                ))
            }
        }
    }

}
