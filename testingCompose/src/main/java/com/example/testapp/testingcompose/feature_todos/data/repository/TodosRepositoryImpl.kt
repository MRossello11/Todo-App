package com.example.testapp.testingcompose.feature_todos.data.repository

import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.core.persistence.todo.TodoDao
import com.example.testapp.testingcompose.feature_todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow

class TodosRepositoryImpl(
    val todoDao: TodoDao
): TodosRepository {
    override fun getTodos(): Flow<List<Todo>> {
        TODO("Not yet implemented")
    }

    override fun getTodoById(id: Int): Todo? {
        TODO("Not yet implemented")
    }

    override fun insertTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override fun deleteTodo(todo: Todo) {
        TODO("Not yet implemented")
    }
}