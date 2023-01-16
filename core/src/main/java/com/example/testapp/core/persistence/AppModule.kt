package com.example.testapp.core.persistence

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTestAppDatabase(app: Application): TestAppDataBase{
        return Room.databaseBuilder(
            app,
            TestAppDataBase::class.java,
            TestAppDataBase.DATABASE_NAME
        ).build()
    }
}