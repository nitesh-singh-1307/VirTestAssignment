package com.example.virtusatestassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtusatestassignment.presentation.Screen
import com.example.virtusatestassignment.presentation.jhonePost_list.PostListScreen
import com.example.virtusatestassignment.ui.theme.PosttocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PosttocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PostListScreen.route
                    ) {
                        composable(
                            route = Screen.PostListScreen.route
                        ) {
                            PostListScreen(navController)
                        }


                    }
                }
            }
        }
    }
}
