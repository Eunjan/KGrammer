package com.midas.kgrammer.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.midas.kgrammer.ui.NavigationKeys.Arg.QUIZ_ID
import com.midas.kgrammer.ui.feature.main.MainScreen
import com.midas.kgrammer.ui.feature.quiz.list.QuizListScreen
import com.midas.kgrammer.ui.feature.quiz.list.QuizListViewModel
import com.midas.kgrammer.ui.feature.quiz.play.QuizPlayScreen
import com.midas.kgrammer.ui.feature.quiz.play.QuizPlayViewModel
import com.midas.kgrammer.ui.feature.review.ReviewScreen
import com.midas.kgrammer.ui.theme.KGrammerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.receiveAsFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KGrammerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KGrammerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    KGrammerTheme {
        KGrammerApp()
    }
}

@Composable
private fun KGrammerApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationKeys.Route.ROUTE_MAIN) {
        composable(route = NavigationKeys.Route.ROUTE_MAIN) {
            MainDestination(navController)
        }
        composable(route = NavigationKeys.Route.ROUTE_QUIZ_LIST) {
            QuizListDestination(navController)
        }
        composable(
            route = NavigationKeys.Route.ROUTE_QUIZ_LIST_PLAY,
            arguments = listOf(navArgument(QUIZ_ID) {
                type = NavType.LongType
            })
        ) {
            QuizPlayDestination()
        }
        composable(route = NavigationKeys.Route.ROUTE_REVIEW) {
            ReviewDestination()
        }
    }
}

@Composable
private fun MainDestination(navController: NavHostController) {
    //val viewModel: FoodCategoriesViewModel = hiltViewModel()
    MainScreen(
        onNavigationRequested = {
            navController.navigate(it)
        }
    )
}

@Composable
private fun QuizListDestination(navController: NavHostController) {
    val viewModel: QuizListViewModel = hiltViewModel()
    QuizListScreen(
        state = viewModel.state,
        effectFlow = viewModel.effects.receiveAsFlow(),
        onNavigationRequested = { itemId ->
            navController.navigate("${NavigationKeys.Route.ROUTE_QUIZ_LIST}/${itemId}")
        }
    )
}

@Composable
private fun QuizPlayDestination() {
    val viewModel: QuizPlayViewModel = hiltViewModel()
    QuizPlayScreen(
        state = viewModel.state
    )
}

@Composable
private fun ReviewDestination() {
    //val viewModel: FoodCategoryDetailsViewModel = hiltViewModel()
    ReviewScreen()
}

object NavigationKeys {

    object Arg {
        const val QUIZ_ID = "quizId"
    }

    object Route {
        const val ROUTE_MAIN = "route_main"
        const val ROUTE_QUIZ_LIST = "route_quiz_list"
        const val ROUTE_QUIZ_LIST_PLAY = "$ROUTE_QUIZ_LIST/{$QUIZ_ID}"
        const val ROUTE_REVIEW = "route_review"
    }

}