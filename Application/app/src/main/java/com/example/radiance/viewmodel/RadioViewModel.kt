package com.example.radiance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.media3.exoplayer.ExoPlayer
import com.example.radiance.data.RadioRepository
import com.example.radiance.model.RadioStation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class RadioViewModel @Inject constructor(
    private val repository: RadioRepository

): ViewModel() {
    private val _stations = MutableStateFlow(false)
    val stations: StateFlow<List<RadioStation>> = _stations

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying

    var player: ExoPlayer? = null

    fun loadStations() {
        _stations.value = repository.getRadioStations()
    }


    fun togglePlay(context, station: RadioStation) {
        if (_isPlaying.value) {
            player?.pause()
        } else {
            player = ExoPlayer.Builder(context).build().apply {
                setMediaItem(Mediaitem.fromUri(station.streamUrl))
                prepare()
                play()
            }
            _isPlaying.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        player?.release()
    }
}