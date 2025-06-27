package com.solodev.space.domain.repository

import com.solodev.space.data.RequestState
import com.solodev.space.domain.model.Rocket
import kotlinx.coroutines.flow.Flow

interface RocketsRepository {
    suspend fun getRockets() : Flow<RequestState<List<Rocket>>>
}