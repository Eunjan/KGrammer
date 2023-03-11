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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.midas.kgrammer.ui.feature.main.MainScreen
import com.midas.kgrammer.ui.feature.question.QuestionListScreen
import com.midas.kgrammer.ui.feature.review.ReviewScreen
import com.midas.kgrammer.ui.theme.KGrammerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KGrammerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    KGrammerTheme {
        FoodApp()
    }
}

@Composable
private fun FoodApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationKeys.Route.ROUTE_MAIN) {
        composable(route = NavigationKeys.Route.ROUTE_MAIN) {
            MainDestination(navController)
        }
        composable(route = NavigationKeys.Route.ROUTE_QUESTION_LIST) {
            QuestionListDestination()
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
private fun QuestionListDestination() {
    //val viewModel: FoodCategoryDetailsViewModel = hiltViewModel()
    QuestionListScreen()
}

@Composable
private fun ReviewDestination() {
    //val viewModel: FoodCategoryDetailsViewModel = hiltViewModel()
    ReviewScreen()
}

object NavigationKeys {

    object Route {
        const val ROUTE_MAIN = "route_main"
        const val ROUTE_QUESTION_LIST = "route_question_list"
        const val ROUTE_REVIEW = "route_review"
    }

}