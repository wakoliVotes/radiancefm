package com.example.radiance.ui.screens

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun RadioScreen(){
    val stations by viewModel.stations.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()

    Column {
        Text(text = "Radio Stations",
            style = MaterialTheme.typography.h2
        )
        LazyColumn{
            items(stations) { station -> }
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        viewModel.togglePlay(LocalContext.current, station)
                    }
                    ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(station.name)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = if(isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = null
                    )
                }
            }
        }
    }
}