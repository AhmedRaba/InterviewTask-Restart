package com.training.interviewtaskrestart.ui.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.training.interviewtaskrestart.PreferencesManager
import com.training.interviewtaskrestart.ui.component.CustomButton

@Composable
fun QuestionsScreen(context: Context) {
    val preferencesManager = PreferencesManager(context)
    val showOverlay = preferencesManager.coverBottomNav
    val highlightPosition = preferencesManager.highlightPosition

    Log.e(
        "QuestionsScreen",
        "QuestionsScreen: $highlightPosition"
    )

    if (showOverlay) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(if (highlightPosition == 3) Color.White else Color.Transparent)
                .padding(8.dp)
                .zIndex(2f)
        ) {
            CustomButton(
                modifier = Modifier.zIndex(2f),
                text = "Filter",
                cornerRadius = 4
            ) {}
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(4) { index ->
                val isHighlighted = (index == 0 && highlightPosition == 4)
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(if (isHighlighted) Color.White else Color.Transparent)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CustomButton(
                        text = "Item $index",
                        cornerRadius = 4
                    ) {}
                }
            }
        }
    }
}
