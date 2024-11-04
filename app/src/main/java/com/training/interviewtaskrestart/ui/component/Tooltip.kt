package com.training.interviewtaskrestart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.interviewtaskrestart.ui.theme.DarkGrey

@Composable
fun Tooltip(
    modifier: Modifier = Modifier,
    text: String,
    triangleOffset: Int = 0,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .background(color = DarkGrey, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp)
                    .width(240.dp), contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = Color.White, fontSize = 14.sp)
            }
            Box(modifier = Modifier.offset(x = triangleOffset.dp)) {
                Spacer(
                    modifier = Modifier
                        .size(width = 20.dp, height = 10.dp)
                        .background(DarkGrey, shape = TriangleShape)
                )
            }
        }
    }
}


val TriangleShape: Shape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, 0f)
    lineTo(size.width / 2, size.height)
    close()
}
