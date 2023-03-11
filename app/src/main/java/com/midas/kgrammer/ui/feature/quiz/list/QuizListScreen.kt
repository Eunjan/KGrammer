package com.midas.kgrammer.ui.feature.quiz.list

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midas.kgrammer.data.model.QuizLevel
import com.midas.kgrammer.ui.theme.KGrammerTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun QuizListScreen(
    state: QuizListContract.State,
    effectFlow: Flow<QuizListContract.Effect>?,
    onNavigationRequested: (itemId: Long) -> Unit
) {
    Box {
        QuizLevelList(quizItems = state.categories) { itemId ->
            onNavigationRequested(itemId)
        }
        if (state.isLoading) {
            LoadingBar()
        }
    }
}

@Composable
fun QuizLevelList(
    quizItems: List<QuizLevel>,
    onItemClicked: (id: Long) -> Unit = { }
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(quizItems) { item ->
            FoodItemRow(item = item, onItemClicked = onItemClicked)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItemRow(
    item: QuizLevel,
    onItemClicked: (id: Long) -> Unit = { }
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier
            .width(200.dp)
            .height(150.dp)
            .padding(16.dp)
            .clickable { onItemClicked(item.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Level",
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                text = item.id.toString(),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                text = if (item.correctPercent >= 0) {
                    "${item.correctPercent}점"
                } else {
                    "미응시"
                },
                fontSize = 15.sp
            )
        }
    }
}


@Composable
fun LoadingBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KGrammerTheme {
        QuizListScreen(QuizListContract.State(), null) { }
    }
}