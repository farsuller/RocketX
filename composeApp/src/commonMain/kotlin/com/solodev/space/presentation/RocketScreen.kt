package com.solodev.space.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RocketsScreen(){

    val viewModel = koinViewModel<RocketsViewModel>()
    val state by viewModel.rockets.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRockets()
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        when {
            state.isLoading -> CircularProgressIndicator()
            state.errorMessage != null -> Text("Error: ${state.errorMessage}")
            else -> LazyColumn {
                items(state.rockets ?: emptyList()) { rocket ->
                    rocket.name?.let {
                        Text(it)
                    }

                }
            }
        }
    }

}