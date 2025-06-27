package com.solodev.space.data.repository

import com.solodev.space.data.remote.SpaceXApi
import com.solodev.space.data.RequestState
import com.solodev.space.domain.model.Rocket
import com.solodev.space.domain.repository.RocketsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RocketsRepositoryImpl(
    private val spaceXApi: SpaceXApi
) : RocketsRepository {
    override suspend fun getRockets(): Flow<RequestState<List<Rocket>>> = flow {
        try {
            emit(RequestState.Success(spaceXApi.getRockets().also { println("Repository Result : $it") }))
        } catch (e: Exception) {
            emit(RequestState.Error(e.message ?: "Unknown Error"))
            println("Repository Result : ${e.message}")
        }
    }.flowOn(Dispatchers.IO)
}