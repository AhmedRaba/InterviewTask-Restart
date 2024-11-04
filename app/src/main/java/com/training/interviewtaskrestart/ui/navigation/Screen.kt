package com.training.interviewtaskrestart.ui.navigation

import com.training.interviewtaskrestart.R

sealed class Screen(val route: String,val icon: Int,val title: String) {

    object HomeScreen : Screen("home_screen", R.drawable.ic_home, "Home")
    object ConnectorScreen : Screen("connector_screen", R.drawable.ic_connector_selected, "Connecter")
    object QuestionsScreen : Screen("questions_screen", R.drawable.ic_question, "Questions")
    object ToolsScreen : Screen("tools_screen", R.drawable.ic_tools, "Tools")
    object ProfileScreen : Screen("profile_screen", R.drawable.ic_profile, "Profile")

}