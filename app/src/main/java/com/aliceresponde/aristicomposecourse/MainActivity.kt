package com.aliceresponde.aristicomposecourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aliceresponde.aristicomposecourse.ui.theme.AristiComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AristiComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val myOptionTitles = listOf("Add a Bag", "Add a Hat", "Add a Chair", "Add a Pizza", "Add a Soda")
                    var selectedOption by rememberSaveable { mutableStateOf("NONE") }
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(16.dp).verticalScroll(rememberScrollState())
                            .background(color = Color.LightGray),
                        horizontalAlignment = Start,
                    ) {

                        var isDialogVisible by rememberSaveable { mutableStateOf(false) }
                        if (isDialogVisible) {
                            LinkAccountDialog(
                                title = "Link Account",
                                accounts = listOf(EmailItem(R.drawable.people_24, "alice@gmail.com")),
                                onDismiss = { isDialogVisible = false }
                            )
                        }
                        Button(onClick = { isDialogVisible = true }) {
                            Text(text = "Show Dialog")
                        }

                        /*
                        MyNotCancellableDialog(isDialogVisible, description = "Its not cancellable Dialog")

                        Button(onClick = { isDialogVisible = true }) {
                            Text(text = "Show Dialog")
                        }*/
                        /*
                        var isDialogVisible by rememberSaveable { mutableStateOf(false) }
                        Button(onClick = { isDialogVisible = true }) {
                            Text(text = "Show Dialog")
                        }
                        MyAlertDialogSample(
                            isVisible = isDialogVisible,
                            title = "My Title",
                            textDescription = "My Description",
                            onConfirm = { isDialogVisible = false },
                            onDismiss = { isDialogVisible = false }
                        )*/

                        //MySlider()
                        //MyDropDownMenu()
                        /*
                        MyDivider(Color.Red)
                        Spacer(modifier = Modifier.padding(16.dp))
                        MyBadgeBox()
                        Spacer(modifier = Modifier.padding(16.dp))
                        MyCard()
                        MySpacer()
                        MyMultipleSelection(
                            selectedOption = selectedOption,
                            options = myOptionTitles,
                            onItemSelected = { selectedOption = it }
                        )
                        */

                        /*
                        MySpacer()
                        MyRadioButton()
                        MyIndeterminateCheckBox()
                        getCheckInfoList(myOptionTitles).forEach { MyCheckBoxWithTextCompleted(it) }
                        MySpacer()
                        MyCheckBoxWithText("Add other Bag - Original")
                        */
                        /*
                        MySwitch()
                         MyProgress()
                         MyIcon()
                         MyCircleImage()
                         MyImage()
                         TextButton(onClick = { Log.d("TAG", "onCreate: was clicked") }) { Text(text = "TextButton") }
                         MyOutlinedButton()
                         MyButton()
                         MyStatelessOutlinedTextField(
                             text = name,
                             textLabel = "Enter your name Without (lower) letter  a",
                         ) { name = removeLetterA(it) }
                         Text(text = "Hello $name")
                         */
                    }
                }
            }
        }
    }

    private fun removeLetterA(it: String): String = if (it.contains("a")) it.replace("a", "") else it
}

