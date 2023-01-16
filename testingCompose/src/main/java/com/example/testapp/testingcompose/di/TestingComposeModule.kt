package com.example.testapp.testingcompose.di

import android.app.Application
import androidx.room.Room
import com.example.testapp.core.persistence.TestAppDataBase
import com.example.testapp.testingcompose.feature_todos.data.repository.TodosRepositoryImpl
import com.example.testapp.testingcompose.feature_todos.domain.repository.TodosRepository
import com.example.testapp.testingcompose.feature_todos.domain.use_case.GetTodos
import com.example.testapp.testingcompose.feature_todos.domain.use_case.TodosUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestingComposeModule {

    @Provides
    @Singleton
    fun provideTodosRepository(db: TestAppDataBase): TodosRepositoryImpl{
        return TodosRepositoryImpl(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideTodosUseCases(repo: TodosRepositoryImpl): TodosUseCases{
        return TodosUseCases(
            getTodos = GetTodos(repo)
        )
    }
}