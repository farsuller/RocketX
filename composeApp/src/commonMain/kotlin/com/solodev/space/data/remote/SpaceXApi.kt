package com.solodev.space.data.remote

import com.solodev.space.domain.model.Rocket
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SpaceXApi(
    private val client: HttpClient
) {
    suspend fun getRockets() : List<Rocket> {
        return client.get("rockets").body()
    }
}