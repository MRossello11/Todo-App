package com.example.testapp.testingcompose.feature_todo.presentation.view

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.testapp.testingcompose.common.Screen

@Composable
fun TodoScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row() {
        Button(onClick = {
            navController.navigate(Screen.TodosScreen.route)
        }) {
            Text(text = "Back")
        }
    }
    Row() {
        Button(onClick = {
            Log.e("A", "B")
        }) {
            Text(text = "Id: $id")
        }
    }
}

