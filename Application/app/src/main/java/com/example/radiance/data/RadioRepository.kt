package com.example.radiance.data

import com.example.radiance.model.RadioStation

class RadioRepository {
    fun getRadioStations(): List<RadioStation> = listOf(
        RadioStation("Radiance FM", ""),
        RadioStation("Urban Vibes", "")
    )
}