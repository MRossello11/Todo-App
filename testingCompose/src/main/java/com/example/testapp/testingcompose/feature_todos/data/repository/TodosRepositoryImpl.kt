package com.example.testapp.testingcompose.feature_todos.data.repository

import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.core.persistence.todo.TodoDao
import com.example.testapp.testingcompose.feature_todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow

class TodosRepositoryImpl(
    val todoDao: TodoDao
): TodosRepository {
    override fun getTodos(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }

    override fun getTodoById(id: Int): Todo? {
        return todoDao.getTodoById(id)
    }

    override fun insertTodo(todo: Todo) {
        todo.id = todoDao.insertTodo(todo).toInt()
    }

    override fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }
}