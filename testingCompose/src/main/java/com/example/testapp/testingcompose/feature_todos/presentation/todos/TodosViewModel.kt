package com.example.testapp.testingcompose.feature_todos.presentation.todos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.testingcompose.feature_todos.domain.use_case.TodosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
    private val todosUseCases: TodosUseCases
) : ViewModel() {
    private val _state = mutableStateOf(TodosState())
    val state: State<TodosState> = _state

    fun onEvent(event: TodosEvent){
        when(event){
            is TodosEvent.Query -> {
                _state.value = state.value.copy(
                    query = event.query
                )
            }
            is TodosEvent.DeleteTodo -> {
                viewModelScope.launch(Dispatchers.IO) {
                    todosUseCases.deleteTodo(event.todo)
                }
                _state.value = state.value.copy(
                    todos = state.value.todos.filter {
                        it.id != event.todo.id
                    }
                )
            }
        }
    }

}