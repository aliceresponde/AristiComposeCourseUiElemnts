package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyMixLayout() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan)
        ) { Text(text = "Ejemplo 1", Modifier.align(Alignment.Center)) }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Red)
            ) { Text(text = "Ejemplo 2", Modifier.align(Alignment.Center)) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Green)
            ) { Text(text = "Ejemplo 3", Modifier.align(Alignment.Center)) }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta)
        ) { Text(text = "Ejemplo 4", Modifier.align(Alignment.BottomCenter)) }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center
    ) {
        Text("1", Modifier.background(Color.Blue))
        Text("2", Modifier.background(Color.Red))
        Text("3", Modifier.background(Color.Yellow))
        Text("4", Modifier.background(Color.Green))
        Text("5", Modifier.background(Color.Blue))
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Greeting(
            name = "Android",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(
            name = "Android2",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(
            name = "Android3",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(
            name = "Android4",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(
            name = "Android5",
            modifier = Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(
            name = "Android",
            modifier = Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Greeting(name = "there", Modifier.background(Color.Red))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Green))
        Greeting(name = "Android", Modifier.background(Color.Blue))
        Greeting(name = "there", Modifier.background(Color.Red))
        Greeting(name = "there", Modifier.background(Color.Yellow))
        Greeting(name = "there", Modifier.background(Color.Green))
    }
}

@Composable
fun MyBox(onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .width(20.dp)
                .height(50.dp)
                .verticalScroll(
                    rememberScrollState(),
                )
                .clickable { onClick() },
            contentAlignment = Alignment.Center,

            ) {
            Text(text = "Esto es un texto que no para de crecer asi que sera un scroll")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}
