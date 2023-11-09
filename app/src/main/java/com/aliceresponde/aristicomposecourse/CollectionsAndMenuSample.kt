package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyDropDownMenu() {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    var expandedState by rememberSaveable { mutableStateOf(false) }
    val myData = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var textFieldWidthSize by remember { mutableStateOf(Size.Zero) }


    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        OutlinedTextField(
            value = selectedValue,
            onValueChange = { selectedValue = it },
            label = { Text(text = "Select an option") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Select an option"
                )
            },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expandedState = true }
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldWidthSize = coordinates.size.toSize()
                }
        )

        DropdownMenu(
            expanded = expandedState,
            onDismissRequest = { expandedState = false }
        ) {
            myData.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        expandedState = false
                        selectedValue = item
                    },
                    text = { Text(text = item) },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldWidthSize.width.toDp() })
                )
            }
        }
    }
}

