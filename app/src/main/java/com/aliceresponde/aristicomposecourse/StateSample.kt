package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyStateSample() {
    //var counter  = 0 // a composable  only use states to update the UI
    //var counter  =  mutableStateOf(0)  // // re create always the counter as 0,  requieres counter.value
    // var counter =   remember { mutableStateOf(0) }  // do not support the recomposition, config change
    //var counter = rememberSaveable { mutableStateOf(0) }  //  support the recomposition, config change but requiere counter.value
    var counter by rememberSaveable { mutableStateOf(0) }  // require import set / get

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Click me")
        }
        Text(text = "The button has been clicked $counter times")
    }
}