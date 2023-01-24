package com.example.testapp.core.persistence.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Todo.TABLE_NAME)
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val title: String,
    val description: String
) {
    companion object{
        const val TABLE_NAME = "Todo"
    }
}

