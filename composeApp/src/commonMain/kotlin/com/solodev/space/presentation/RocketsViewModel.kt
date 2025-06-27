package com.solodev.space.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solodev.space.data.RequestState
import com.solodev.space.domain.usecase.GetRocketXUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RocketsViewModel(
    private val rocketUseCase: GetRocketXUseCase
) : ViewModel() {

    private val _rockets = MutableStateFlow(RocketsStates())
    val rockets: StateFlow<RocketsStates> = _rockets.asStateFlow()

    fun getRockets() = viewModelScope.launch{
        rocketUseCase
            .getRockets
            .invoke()
            .onStart { _rockets.update { it.copy(isLoading = true) } }
            .catch { e -> _rockets.update { it.copy(isLoading = false, errorMessage = e.message) } }
            .collectLatest { response ->
                when (response) {
                    is RequestState.Success -> {
                        _rockets.update { it.copy(isLoading = false, rockets = response.result) }
                    }
                    is RequestState.Error -> {
                        _rockets.update { it.copy(isLoading = false, errorMessage = response.message) }
                    }
                }
            }
    }
}