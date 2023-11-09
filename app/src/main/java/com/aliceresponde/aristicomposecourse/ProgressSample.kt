package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress() {
    var showProgress by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showProgress) {
            CircularProgressIndicator(color = Color.Blue, strokeWidth = 4.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Blue,
                trackColor = Color.Red
            )
        }

        Button(modifier = Modifier.padding(bottom = 16.dp), onClick = { showProgress = !showProgress }) {
            Text(text = if (!showProgress) "Show Progress" else "Hide Progress")
        }
    }
}