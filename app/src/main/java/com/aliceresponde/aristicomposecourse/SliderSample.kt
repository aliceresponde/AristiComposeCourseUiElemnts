package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MySlider() {
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }
    var sliderLabel by rememberSaveable { mutableStateOf("0") }

    Column {
        Slider(
            value = sliderPosition,
            valueRange = 0f..1f,
            steps = 9,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {
                sliderLabel =  sliderPosition.toString()
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    sliderPosition =
                        if (sliderPosition > 0f) sliderPosition - 0.1f
                        else 0f
                    sliderLabel = sliderPosition.toString()
                },
                enabled = sliderPosition > 0f
            ) { Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Down") }

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = sliderLabel
            )

            Button(
                onClick = {
                    sliderPosition =
                        if (sliderPosition < 1) sliderPosition + 0.1f
                        else 1f
                    sliderLabel = sliderPosition.toString()
                },
                enabled = sliderPosition < 1f
            ) { Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "Up") }
        }
    }
}