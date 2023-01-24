package com.example.testapp.testingcompose.feature_todos.domain.use_case

import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.testingcompose.feature_todos.domain.repository.TodosRepository

class DeleteTodo(
    private val repository: TodosRepository
) {
    operator fun invoke(todo: Todo){
        repository.deleteTodo(todo)
    }
}