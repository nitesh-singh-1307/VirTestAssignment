package com.example.virtusatestassignment.presentation.jhonePost_list
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virtusatestassignment.common.Resource
import com.example.virtusatestassignment.domain.use_case.get_post.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {
    private val _state = mutableStateOf(PostListState())
    val state: State<PostListState> = _state
    private val endPoint = "john%203:16"

    init {
        getCoins()
    }

    private fun getCoins() {
        getPostUseCase(endPoint).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("TAG","checkResult:::::${result.data!!}")
                    _state.value = PostListState(coins = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = PostListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PostListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}