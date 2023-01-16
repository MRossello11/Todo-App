package com.example.testapp.testingcompose.feature_todos.presentation.todos

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.testapp.testingcompose.common.Screen
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodosScreen(
    navController: NavController,
    viewModel: TodosViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Row() {

        Button(
            onClick = {
                navController.navigate(
                    Screen.TodoScreen.route +
                            "?id=${state.query}"
                )
            }
        ) {
            Text(text = "Hello")
        }
    }

    Row(){
        TextField(
            value = "A",
            onValueChange = {
                viewModel.onEvent(TodosEvent.Query(it))
            }
        )
    }
}