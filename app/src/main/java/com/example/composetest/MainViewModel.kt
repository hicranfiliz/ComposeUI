package com.example.composetest

import androidx.lifecycle.ViewModel
import com.example.composetest.Data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val personRepository: PersonRepository
): ViewModel(){
    val readAll = personRepository.readAll
}