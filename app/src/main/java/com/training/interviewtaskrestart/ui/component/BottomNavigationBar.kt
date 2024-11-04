package com.training.interviewtaskrestart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.training.interviewtaskrestart.ui.navigation.Screen
import com.training.interviewtaskrestart.ui.theme.Cyan

@Composable
fun BottomNavigationBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf(
        Screen.HomeScreen,
        Screen.ConnectorScreen,
        Screen.QuestionsScreen,
        Screen.ToolsScreen,
        Screen.ProfileScreen,
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { screen ->
            val isSelected = currentRoute == screen.route

            Box(
                modifier = Modifier
                    .clickable(interactionSource = null, indication = null) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    .padding(8.dp)
                    .height(60.dp)
                    .background(
                        if (isSelected) Color.White else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .weight(1f), contentAlignment = Alignment.Center

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        tint = if (isSelected) Cyan else Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = screen.title,
                        color = if (isSelected) Cyan else Color.Gray,
                        maxLines = 1, fontSize = 12.sp,
                        overflow = TextOverflow.Visible
                    )
                }
            }
        }
    }
}
