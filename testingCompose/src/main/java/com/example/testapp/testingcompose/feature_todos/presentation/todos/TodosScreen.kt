package com.example.testapp.testingcompose.feature_todos.presentation.todos

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.testapp.testingcompose.feature_todos.presentation.todos.components.TodoItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalAnimationApi
@Composable
fun TodosScreen(
    navController: NavController,
    viewModel: TodosViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    viewModel.onEvent(TodosEvent.Query(""))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Todos") //todo resource
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Scaffold(
            floatingActionButton = {
                // TODO add todo item
            },
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(state.todos) { todo ->
                        TodoItem(
                            todo = todo,
                            modifier = Modifier
                                .fillMaxWidth(),
                            onDeleteClick = { viewModel.onEvent(TodosEvent.DeleteTodo(todo)) }
                        )
                    }
                }
            }
        }
    }
}