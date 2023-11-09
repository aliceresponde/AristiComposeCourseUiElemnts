package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun MyMultipleSelection(
    selectedOption: String,
    options: List<String> = listOf("A", "B", "C", "D"),
    onItemSelected: (String) -> Unit
) {
    Column (Modifier.fillMaxWidth()){
        options.forEach { item ->
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == item,
                    onClick = { onItemSelected(item) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                        unselectedColor = Color.Black,
                        disabledSelectedColor = Color.Gray,
                        disabledUnselectedColor = Color.LightGray
                    )
                )
                Text(text = item)
            }
        }
    }
}

/**
 * A RadioButtom should not  be alone, its a Single option from multiple options
 */
@Composable
fun MyRadioButton() {
    var isSelected by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = {isSelected = !isSelected},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Black,
                disabledSelectedColor = Color.Gray,
                disabledUnselectedColor = Color.LightGray
            )
        )

        Text(text = "Add other Bag")

    }
}

@Composable
fun MyIndeterminateCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getCheckInfoList(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var isCheckedStatus by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            checked = isCheckedStatus,
            onCheckedChange = { myNewState -> isCheckedStatus = myNewState }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(data: CheckInfo) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = data.checked,
            onCheckedChange = { data.onCheckedChange(!data.checked) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                checkmarkColor = Color.White,
                uncheckedColor = Color.Black
            )
        )
        Text(data.title)
    }
}

data class CheckInfo(val title: String, var checked: Boolean, val onCheckedChange: (Boolean) -> Unit)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCheckBoxWithText(text: String = "Add other Bag") {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = !checked },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                checkmarkColor = Color.White,
                uncheckedColor = Color.Black
            )
        )
        Text(text)
    }
}

@Composable
fun MySwitch() {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = !checked },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color.Blue,
                uncheckedThumbColor = Color.Gray,
                uncheckedTrackColor = Color.LightGray
            )
        )
        Text(text = "Add other Bag")
    }
}
