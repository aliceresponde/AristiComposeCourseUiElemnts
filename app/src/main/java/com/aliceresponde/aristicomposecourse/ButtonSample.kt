package com.aliceresponde.aristicomposecourse

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyOutlinedButton() {
    var btnState by rememberSaveable { mutableStateOf(true) }
    Column {
        OutlinedButton(
            onClick = { btnState = !btnState },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            enabled = btnState,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black,
                disabledContentColor = Color.Gray,
            ),
            shape = CircleShape // RectangleShape
        ) {
            Text(text = "MyOutlinedButton")
        }

    }
}

@Composable
fun MyButton() {
    var btnState by rememberSaveable { mutableStateOf(true) }
    Column {
        Button(
            onClick = {
                Log.d("TAG", "MyButton: was clicked")
                btnState = !btnState
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                disabledContentColor = Color.Gray,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            enabled = btnState,
            border = BorderStroke(5.dp, Color.Green),

            ) {
            Text(text = "MyButton")
        }
    }
}