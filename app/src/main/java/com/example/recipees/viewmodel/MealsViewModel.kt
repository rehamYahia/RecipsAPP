package com.example.recipees.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipees.model.Response
import com.example.recipees.repo.MealsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealsRepo: MealsRepo) :ViewModel() {
    private val _firstMeal : MutableStateFlow<Response?> = MutableStateFlow(null)
     val firstMeal : StateFlow<Response?> = _firstMeal

    fun getFirstMeal(){
        viewModelScope.launch {
//            _firstMeal.emit(mealsRepo.getMealsFromRemote())
            _firstMeal.value = mealsRepo.getMealsFromRemote()
        }
    }
}
