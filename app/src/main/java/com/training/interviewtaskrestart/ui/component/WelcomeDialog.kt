package com.training.interviewtaskrestart.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeDialog(onYesClicked: () -> Unit, onNoClicked: () -> Unit) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Welcome to my app", fontSize = 30.sp) },
        text = { Text(text = "Do you want to see the tutorial?") },
        confirmButton = {
            Button(onClick = onYesClicked) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(onClick = onNoClicked) {
                Text("No")
            }
        }
    )
}
