package com.example.testapp.testingcompose.feature_todos.domain.repository

import com.example.testapp.core.persistence.todo.Todo
import kotlinx.coroutines.flow.Flow

interface TodosRepository {
    fun getTodos(): Flow<List<Todo>>

    fun getTodoById(id: Int): Todo?

    fun insertTodo(todo: Todo)

    fun deleteTodo(todo: Todo)
}