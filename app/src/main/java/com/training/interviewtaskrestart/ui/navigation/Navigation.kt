package com.training.interviewtaskrestart.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.interviewtaskrestart.ui.component.BottomNavigationBar
import com.training.interviewtaskrestart.ui.component.TutorialOverlay
import com.training.interviewtaskrestart.ui.component.WelcomeDialog
import com.training.interviewtaskrestart.ui.screen.ConnectorScreen
import com.training.interviewtaskrestart.ui.screen.HomeScreen
import com.training.interviewtaskrestart.ui.screen.ProfileScreen
import com.training.interviewtaskrestart.ui.screen.QuestionsScreen
import com.training.interviewtaskrestart.ui.screen.ToolsScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val showTutorial = remember { mutableStateOf(false) }
    val userFirstTime = remember { mutableStateOf(true) }
    val triangleOffsets = listOf(-94, -62, 0, 20, -20)
    val tooltipOffsets = listOf(-66, -20, 0, 15, -15)
    val instructions = listOf(
        "You will find your study plan here.",
        "You will find study partners and people to connect with here.",
        "Here are the questions with model answers.",
        "You can filter to see a specific type of questions.",
        "Click here to see by categories with progression."
    )
    val screens = listOf(
        Screen.HomeScreen.route,
        Screen.ConnectorScreen.route,
        Screen.QuestionsScreen.route
    )

    Scaffold(bottomBar = {
        BottomNavigationBar(navController, showTutorial.value)
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

            if (userFirstTime.value) {
                WelcomeDialog(
                    onYesClicked = {
                        userFirstTime.value = false
                        showTutorial.value = true
                    },
                    onNoClicked = {
                        showTutorial.value = false
                        userFirstTime.value = false
                    }
                )
            }
            if (showTutorial.value) {
                TutorialOverlay(
                    showTutorial = showTutorial.value,
                    instructions = instructions,
                    tooltipOffsets = tooltipOffsets,
                    triangleOffsets = triangleOffsets,
                    screens = screens,
                    navController = navController
                ) {
                    showTutorial.value = false
                }

            }
        }
    }
}

