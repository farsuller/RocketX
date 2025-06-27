package com.solodev.space.presentation

import com.solodev.space.domain.model.Rocket

data class RocketsStates(
    val isLoading: Boolean = true,
    val rockets : List<Rocket>? = null,
    val errorMessage : String? = null
)
