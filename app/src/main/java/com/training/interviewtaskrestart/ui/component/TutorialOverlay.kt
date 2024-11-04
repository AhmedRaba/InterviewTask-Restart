package com.training.interviewtaskrestart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.training.interviewtaskrestart.ui.navigation.Screen

@Composable
fun TutorialOverlay(
    showTutorial: Boolean,
    instructions: List<String>,
    tooltipOffsets: List<Int>,
    triangleOffsets: List<Int>,
    screens: List<String>,
    navController: NavController,
    onTutorialDismiss: () -> Unit,
) {
    val currentTriangleIndex = remember { mutableIntStateOf(0) }
    val currentTooltipIndex = remember { mutableIntStateOf(0) }
    val currentInstructionIndex = remember { mutableIntStateOf(0) }
    val currentScreensIndex = remember { mutableIntStateOf(0) }

    if (showTutorial) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        ) {

            Tooltip(
                text = instructions[currentInstructionIndex.intValue],
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 80.dp)
                    .offset(x = tooltipOffsets[currentTooltipIndex.intValue].dp)
                    .zIndex(2f),
                triangleOffset = triangleOffsets[currentTriangleIndex.intValue]
            )

            Button(modifier = Modifier.align(Alignment.Center), onClick = {
                if (currentTooltipIndex.intValue < tooltipOffsets.size - 1) {
                    currentTriangleIndex.intValue++
                    currentTooltipIndex.intValue++
                    currentInstructionIndex.intValue++

                    if (currentScreensIndex.intValue < screens.size - 1) {
                        currentScreensIndex.intValue++
                        navController.navigate(screens[currentScreensIndex.intValue])
                    }
                } else {
                    navController.navigate(Screen.HomeScreen.route)
                    onTutorialDismiss()
                }
            }) {
                Text("Got it")
            }
        }
    }
}
