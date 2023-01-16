package com.example.testapp.core.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.core.persistence.todo.Todo
import com.example.testapp.core.persistence.todo.TodoDao

@Database(
    entities = [Todo::class],
    version = 1
)
abstract class TestAppDataBase: RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object{
        const val DATABASE_NAME = "count_db"
    }
}