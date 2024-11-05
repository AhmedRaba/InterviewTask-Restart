package com.training.interviewtaskrestart.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.training.interviewtaskrestart.ui.theme.Cyan

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = Cyan,
    contentColor: Color = Color.White,
    cornerRadius: Int = 10,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(cornerRadius.dp)
    ) {
        Text(text = text, color = contentColor)
    }

}

