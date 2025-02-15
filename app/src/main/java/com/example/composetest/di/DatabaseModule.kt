package com.example.composetest.di

import android.content.Context
import androidx.room.Room
import com.example.composetest.Data.Person
import com.example.composetest.Data.PersonDao
import com.example.composetest.Data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): PersonDatabase = Room.databaseBuilder(
        context,
        PersonDatabase::class.java,
        "my_database"
    ).createFromAsset("database/person.db").build()

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase): PersonDao = database.personDao()
}