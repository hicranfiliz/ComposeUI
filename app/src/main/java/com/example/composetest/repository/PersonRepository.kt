package com.example.composetest.repository

import com.example.composetest.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "Hicran",
                lastName = "Filiz",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Maria",
                lastName = "Filiz",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "John",
                lastName = "Filiz",
                age = 21
            ),
            Person(
                id = 3,
                firstName = "Mary",
                lastName = "Filiz",
                age = 40
            ),
            Person(
                id = 4,
                firstName = "Tom",
                lastName = "Filiz",
                age = 12
            ),
            Person(
                id = 5,
                firstName = "Sam",
                lastName = "Filiz",
                age = 28
            ),
            Person(
                id = 6,
                firstName = "Katty",
                lastName = "Filiz",
                age = 48
            ),
            Person(
                id = 7,
                firstName = "Philips",
                lastName = "Filiz",
                age = 19
            ),
            Person(
                id = 0,
                firstName = "Hicran",
                lastName = "Filiz",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Maria",
                lastName = "Filiz",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "John",
                lastName = "Filiz",
                age = 21
            ),
            Person(
                id = 3,
                firstName = "Mary",
                lastName = "Filiz",
                age = 40
            ),
            Person(
                id = 4,
                firstName = "Tom",
                lastName = "Filiz",
                age = 12
            ),
            Person(
                id = 0,
                firstName = "Hicran",
                lastName = "Filiz",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Maria",
                lastName = "Filiz",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "John",
                lastName = "Filiz",
                age = 21
            ),
            Person(
                id = 3,
                firstName = "Mary",
                lastName = "Filiz",
                age = 40
            ),
            Person(
                id = 4,
                firstName = "Tom",
                lastName = "Filiz",
                age = 12
            ),
        )
    }
}