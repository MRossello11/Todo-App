package com.example.testapp.testingcompose.feature_todos.presentation.todos

import com.example.testapp.core.persistence.todo.Todo

sealed class TodosEvent {
    data class Query(val query: String): TodosEvent()
    data class DeleteTodo(val todo: Todo): TodosEvent()
}