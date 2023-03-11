package com.midas.kgrammer.ui.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.midas.kgrammer.R
import com.midas.kgrammer.ui.NavigationKeys

@Composable
fun MainScreen(
    onNavigationRequested: (route: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image"
            )
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 5.dp),
                onClick = {
                    onNavigationRequested.invoke(NavigationKeys.Route.ROUTE_QUESTION_LIST)
                }
            ) {
                Text(text = stringResource(id = R.string.start))
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 10.dp, 40.dp, 40.dp),
                onClick = {
                    onNavigationRequested.invoke(NavigationKeys.Route.ROUTE_REVIEW)
                }
            ) {
                Text(text = stringResource(id = R.string.review_note))
            }
        }
    }


}