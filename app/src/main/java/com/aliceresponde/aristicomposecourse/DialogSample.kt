package com.aliceresponde.aristicomposecourse

import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun LinkAccountDialog(
    title: String,
    accounts: List<EmailItem> = listOf(),
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)
        ) {
            MyTitle(text = title)

            accounts.forEach { account ->
                AccountItem(
                    item = account,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            AccountItem(
                item = EmailItem(R.drawable.face_24, "Add Account"),
                onClick = {
                    Toast.makeText(context, "Add Account", Toast.LENGTH_SHORT).show()
                }
            )

        }
    }
}

data class EmailItem(@DrawableRes var image: Int, var email: String)

@Composable
fun AccountItem(
    item: EmailItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {onClick()}),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = CenterVertically,
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "Avatar",
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(40.dp)
        )

        Text(text = item.email, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp))
    }
}

@Composable
fun MyNotCancellableDialog(isVisible: Boolean, description: String = "My Description") {
    if (isVisible) {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )

        ) {
            Text(modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color.LightGray), text = description)
        }
    }
}

@Composable
fun MyAlertDialogSample(
    title: String,
    textDescription: String,
    isVisible: Boolean,
    confirmButtonLabel: String = "Confirm",
    dismissButtonLabel: String = "Cancel",
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = {

        },
        title = { Text(text = title) },
        text = { Text(text = textDescription) },

        confirmButton = {
            TextButton(onClick = {
                onConfirm()
                Toast.makeText(context, confirmButtonLabel, Toast.LENGTH_SHORT).show()
            }) {
                Text(text = confirmButtonLabel)
            }

        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
                Toast.makeText(context, dismissButtonLabel, Toast.LENGTH_SHORT).show()
            }) {
                Text(text = dismissButtonLabel)
            }
        }
    )
}