package com.example.testapp.testingcompose.feature_todos.domain.repository

import com.example.testapp.core.persistence.todo.Todo
import kotlinx.coroutines.flow.Flow

interface TodosRepository {
    fun getTodos(): Flow<List<com.example.testapp.core.persistence.todo.Todo>>

    fun getTodoById(id: Int): com.example.testapp.core.persistence.todo.Todo?

    fun insertTodo(todo: com.example.testapp.core.persistence.todo.Todo)

    fun deleteTodo(todo: com.example.testapp.core.persistence.todo.Todo)
}