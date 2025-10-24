package com.barca.responsi1mobileh1d023006.data.network

import com.barca.responsi1mobileh1d023006.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("v4/teams/{id}")
    suspend fun getTeams(
        @Path("id") teamId: String,
        @Header("X-Auth-Token") token: String
    ): Response<TeamResponse>
}