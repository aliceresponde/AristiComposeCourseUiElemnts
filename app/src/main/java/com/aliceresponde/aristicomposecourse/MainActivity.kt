package com.aliceresponde.aristicomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.aliceresponde.aristicomposecourse.ui.theme.AristiComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AristiComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    var myText by rememberSaveable { mutableStateOf("") }

                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        MyStatelessOutlinedTextField(text = myText, textLabel = "Enter your name", onValueChange = {
                            myText = if (it.contains("a")) it.replace("a", "") else it
                        })


                        Text(text = "Hello World!")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStatelessOutlinedTextField(text: String, textLabel: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .horizontalScroll(rememberScrollState())
            .verticalScroll(rememberScrollState()),
        onValueChange = { onValueChange(it) },
        label = { Text(text = textLabel) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyOutlinedTextField() {
    var myText by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .horizontalScroll(rememberScrollState())
            .verticalScroll(rememberScrollState()),
        onValueChange = { myText = if (it.contains("a")) it.replace("a", "") else it },
        label = { Text(text = "Enter your name") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = { myText = if (it.contains("a")) it.replace("a", "") else it },
        label = { Text(text = "Enter your name") }
    )
}

@Composable
fun MyTextSample() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World!")
        Text(text = "Hello World!", color = Color.Red)
        Text(text = "Hello World!", Modifier.size(100.dp, 100.dp))
        Text(
            text = "Hello World!",
            Modifier
                .size(100.dp, 100.dp)
                .background(Color.Red)
        )
        Text(text = "Hello World!", fontSize = 20.sp)
        Text(text = "Hello World!", fontFamily = FontFamily.Cursive)
        Text(text = "Hello World!", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Text(text = "Hello World!", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Hello World!",
            style = TextStyle(
                fontFamily = FontFamily.Cursive,
                fontSize = 20.sp,
                textDecoration = TextDecoration.LineThrough
            )
        )
        Text(
            text = "Hello World!", style = TextStyle(
                fontFamily = FontFamily.Cursive, fontSize = 20.sp, textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )

    }
}
