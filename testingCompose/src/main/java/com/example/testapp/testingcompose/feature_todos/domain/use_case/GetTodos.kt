package com.example.testapp.testingcompose.feature_todos.domain.use_case

import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.testingcompose.feature_todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetTodos(
    repository: TodosRepository
) {
    operator fun invoke(): Flow<List<Todo>>{
        return flowOf()
    }
}