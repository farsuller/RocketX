package com.solodev.space.domain.usecase

import com.solodev.space.data.RequestState
import com.solodev.space.domain.model.Rocket
import com.solodev.space.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.Flow

class GetRockets(
    private val rocketRepository: RocketsRepository
) {
    suspend operator fun invoke() : Flow<RequestState<List<Rocket>>> = rocketRepository.getRockets()
}