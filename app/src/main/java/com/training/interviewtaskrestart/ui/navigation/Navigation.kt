package com.training.interviewtaskrestart.ui.navigation

import com.training.interviewtaskrestart.ui.screen.HomeScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.interviewtaskrestart.ui.component.BottomNavigationBar
import com.training.interviewtaskrestart.ui.screen.ConnectorScreen
import com.training.interviewtaskrestart.ui.screen.ProfileScreen
import com.training.interviewtaskrestart.ui.screen.QuestionsScreen
import com.training.interviewtaskrestart.ui.screen.ToolsScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->

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


    }

}