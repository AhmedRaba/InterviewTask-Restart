package com.training.interviewtaskrestart.ui.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.training.interviewtaskrestart.PreferencesManager
import com.training.interviewtaskrestart.ui.navigation.Screen

@Composable
fun TutorialOverlay(
    showTutorial: Boolean,
    instructions: List<String>,
    tooltipHorizontalOffsets: List<Int>,
    tooltipVerticalOffsets: List<Int>,
    triangleOffsets: List<Int>,
    screens: List<String>,
    navController: NavController,
    context: Context,
    onTutorialDismiss: () -> Unit,
) {
    val currentTriangleIndex = remember { mutableIntStateOf(0) }
    val currentTooltipHorizontalIndex = remember { mutableIntStateOf(0) }
    val currentTooltipVerticalIndex = remember { mutableIntStateOf(0) }
    val currentInstructionIndex = remember { mutableIntStateOf(0) }
    val currentScreensIndex = remember { mutableIntStateOf(0) }
    val preferencesManager = PreferencesManager(context)
    val removeOverlay = remember {
        mutableStateOf(false)
    }

    if (showTutorial) {
        Box(
            modifier = Modifier.then(
                if (removeOverlay.value) {
                    Modifier.fillMaxSize()
                } else Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
        ) {

            Tooltip(
                text = instructions[currentInstructionIndex.intValue],
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 82.dp)
                    .offset(
                        x = tooltipHorizontalOffsets[currentTooltipHorizontalIndex.intValue].dp,
                        y = tooltipVerticalOffsets[currentTooltipVerticalIndex.intValue].dp
                    )
                    .zIndex(2f),
                triangleOffset = triangleOffsets[currentTriangleIndex.intValue]
            )

            CustomButton(
                modifier = Modifier.align(Alignment.Center),
                text = "Got it",
                backgroundColor = Color.Black,
                onClick = {
                    if (currentTooltipHorizontalIndex.intValue < tooltipHorizontalOffsets.size - 1) {
                        currentTriangleIndex.intValue++
                        currentTooltipHorizontalIndex.intValue++
                        currentTooltipVerticalIndex.intValue++
                        currentInstructionIndex.intValue++

                        if (currentScreensIndex.intValue < screens.size - 1) {
                            currentScreensIndex.intValue++
                            navController.navigate(screens[currentScreensIndex.intValue])
                        }

                        if (currentTooltipHorizontalIndex.intValue == 2) {
                            removeOverlay.value = false
                            preferencesManager.coverBottomNav = false

                        }

                        if (currentTooltipHorizontalIndex.intValue == 3) {
                            removeOverlay.value = true
                            preferencesManager.coverBottomNav = true
                            preferencesManager.highlightPosition=3
                        }
                        if (currentTooltipHorizontalIndex.intValue == 4) {
                            preferencesManager.coverBottomNav = true
                            preferencesManager.highlightPosition=4
                        }


                    } else {
                        navController.navigate(Screen.HomeScreen.route)
                        preferencesManager.showTutorial = false
                        onTutorialDismiss()
                        preferencesManager.highlightPosition=-1
                    }


                })
        }

    }
}
