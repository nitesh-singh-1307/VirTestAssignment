package com.example.virtusatestassignment.presentation

sealed class Screen(val route: String) {
    object PostListScreen: Screen("post_list_screen")
}