package com.example.virtusatestassignment.presentation.jhonePost_list
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PostListScreen(
    navController: NavController,
    viewModel: PostListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Log.d("TAG","checkState::::::$state")
    Box(modifier = Modifier.fillMaxSize()) {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(state.coins) { coin ->
//                PostListItem(
//                    coin = coin,
//                    onItemClick = {
//                        navController.navigate(Screen.PostListScreen.route + "/${coin.book_id}")
//                    }
//                )
//            }
//        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${state.coins.reference}",
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${state.coins.translation_name}",
                color = Color.Green,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${state.coins.translation_note}",
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${state.coins.text}",
                color = Color.Green,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }


        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}