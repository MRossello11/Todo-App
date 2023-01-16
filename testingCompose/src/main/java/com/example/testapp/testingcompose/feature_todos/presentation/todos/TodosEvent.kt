package com.example.testapp.testingcompose.feature_todos.presentation.todos

sealed class TodosEvent {
    data class Query(val query: String): TodosEvent()
}