package com.example.composetest.Data

import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personDao: PersonDao
){
    val readAll = personDao.readAll()
}