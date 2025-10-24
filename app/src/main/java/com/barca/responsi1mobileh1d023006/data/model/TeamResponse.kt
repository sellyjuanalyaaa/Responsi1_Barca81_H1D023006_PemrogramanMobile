package com.barca.responsi1mobileh1d023006.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamResponse(
    @SerializedName("coach") val coach: Coach?,
    @SerializedName("squad") val squad: List<Player>?
) : Serializable

data class Coach(
    @SerializedName("name") val name: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("nationality") val nationality: String?
) : Serializable


data class Player(
    @SerializedName("name") val name: String?,
    @SerializedName("position") val position: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("nationality") val nationality: String?
) : Serializable
