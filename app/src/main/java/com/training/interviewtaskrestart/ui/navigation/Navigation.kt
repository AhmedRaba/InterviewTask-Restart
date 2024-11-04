package com.training.interviewtaskrestart.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.interviewtaskrestart.ui.component.BottomNavigationBar
import com.training.interviewtaskrestart.ui.component.Tooltip
import com.training.interviewtaskrestart.ui.screen.ConnectorScreen
import com.training.interviewtaskrestart.ui.screen.HomeScreen
import com.training.interviewtaskrestart.ui.screen.ProfileScreen
import com.training.interviewtaskrestart.ui.screen.QuestionsScreen
import com.training.interviewtaskrestart.ui.screen.ToolsScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val showTooltip = remember {
        mutableStateOf(true)
    }
    val triangleOffsets = listOf(-94, -62, 0, 20, -20)
    val tooltipOffsets = listOf(-66, -20, 0, 15, -15)
    val instructions = listOf(
        "You will find your study plan here.",
        "You will find study partners and people to connect with here.",
        "Here are the questions with model answers.",
        "You can filter to see a specific type of questions.",
        "Click here to see by categories with progression."
    )
    val screens =
        listOf(Screen.HomeScreen.route, Screen.ConnectorScreen.route, Screen.QuestionsScreen.route)

    val currentTriangleIndex = remember { mutableIntStateOf(0) }
    val currentTooltipIndex = remember { mutableIntStateOf(0) }
    val currentInstructionIndex = remember { mutableIntStateOf(0) }
    val currentScreensIndex = remember { mutableIntStateOf(0) }



    Scaffold(bottomBar = {
        BottomNavigationBar(navController)
    }) { innerPadding ->


        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = Screen.HomeScreen.route,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(route = Screen.HomeScreen.route) { HomeScreen() }
                composable(route = Screen.ConnectorScreen.route) { ConnectorScreen() }
                composable(route = Screen.QuestionsScreen.route) { QuestionsScreen() }
                composable(route = Screen.ToolsScreen.route) { ToolsScreen() }
                composable(route = Screen.ProfileScreen.route) { ProfileScreen() }
            }

            if (showTooltip.value) {

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
                    Button(
                        onClick = {
                            currentTriangleIndex.intValue =
                                (currentTriangleIndex.intValue + 1) % triangleOffsets.size
                            currentTooltipIndex.intValue =
                                (currentTooltipIndex.intValue + 1) % tooltipOffsets.size
                            currentInstructionIndex.intValue =
                                (currentInstructionIndex.intValue + 1) % instructions.size
                            currentScreensIndex.intValue =
                                (currentScreensIndex.intValue + 1) % instructions.size

                            navController.navigate(screens[currentScreensIndex.intValue])

                        }, modifier = Modifier.align(Alignment.TopCenter)
                    ) {
                        Text("Move Tooltip")
                    }
                }
            }

        }

    }


}