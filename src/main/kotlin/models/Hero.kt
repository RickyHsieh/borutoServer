package com.purplestudio.models

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val rating: Double,
    val power: Double,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>

)
