package com.example.virtusatestassignment.presentation.jhonePost_list

import com.example.virtusatestassignment.data.remote.dto.JhonBook



data class PostListState(
    val isLoading: Boolean = false,
    val coins: JhonBook = JhonBook("","","","","",emptyList()),
    val error: String = ""
)