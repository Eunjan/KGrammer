package com.midas.kgrammer.ui.feature.quiz.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midas.kgrammer.data.repository.QuizListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizListViewModel @Inject constructor(private val quizListRepository: QuizListRepository) :
    ViewModel() {

    var state by mutableStateOf(
        QuizListContract.State(
            categories = listOf(),
            isLoading = true
        )
    )
        private set

    var effects = Channel<QuizListContract.Effect>(Channel.UNLIMITED)
        private set

    init {
        viewModelScope.launch { getFoodCategories() }
    }

    private suspend fun getFoodCategories() {
        val categories = quizListRepository.getQuizList()
        viewModelScope.launch {
            state = state.copy(categories = categories, isLoading = false)
            effects.send(QuizListContract.Effect.DataWasLoaded)
        }
    }
}