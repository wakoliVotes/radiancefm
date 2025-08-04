package com.example.radiance.model

data class RadioStation(
    val name: String,
    val streamUrl: String,
    val genre: String = "",
    val logUrl: String = "" // optional image
)
