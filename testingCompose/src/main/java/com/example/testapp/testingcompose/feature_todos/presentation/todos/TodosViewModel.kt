package com.example.testapp.testingcompose.feature_todos.presentation.todos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.testingcompose.feature_todos.domain.use_case.TodosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
    private val todosUseCases: TodosUseCases
) : ViewModel() {
    private val _state = mutableStateOf(TodosState())
    val state: State<TodosState> = _state

    private var todoJob: Job? = null

    init {
        getTodos("")
    }

    fun onEvent(event: TodosEvent){
        when(event){
            is TodosEvent.Query -> {
                getTodos(event.query)
            }
            is TodosEvent.DeleteTodo -> {
                deleteTodo(event.todo)
            }
        }
    }

    private fun deleteTodo(todo: Todo) {
        todoJob?.cancel()
        todoJob =
            viewModelScope.launch(Dispatchers.IO) {
                todosUseCases.deleteTodo(todo)
                _state.value = state.value.copy(
                    todos = state.value.todos.filter {
                        it.id != todo.id
                    }
                )
            }
    }

    private fun getTodos(query: String) {
        todoJob?.cancel()
        todoJob =
            todosUseCases.getTodos()
                .onEach { todos ->
                    _state.value = state.value.copy(
                        todos = todos.filter { it.title.contains(query) },
                        query = query
                    )
                }
                .launchIn(viewModelScope)
    }
}