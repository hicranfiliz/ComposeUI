package com.example.composetest.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personDao() : PersonDao
}