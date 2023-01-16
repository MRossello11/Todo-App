package com.example.testapp.testingcompose.feature_todos.presentation.todos

import com.example.testapp.core.persistence.todo.Todo

data class TodosState(
    val todos: List<com.example.testapp.core.persistence.todo.Todo> = emptyList(),
    val query: String = ""
)