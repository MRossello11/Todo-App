package com.example.testapp.core.persistence.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("select * from ${Todo.TABLE_NAME}")
    fun getTodos(): Flow<List<Todo>>

    @Query("select * from ${Todo.TABLE_NAME} where id = :todoId")
    fun getTodoById(todoId: Int): Todo

    @Insert(onConflict = REPLACE)
    fun insertTodo(todo: Todo): Long

    @Delete
    fun deleteTodo(todo: Todo)

}