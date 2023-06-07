package com.example.recipees.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipees.model.MealsData
import com.example.recipees.repo.MealsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealsRepo: MealsRepo) :ViewModel() {
    private val _firstMeal : MutableStateFlow<ArrayList<MealsData>?> = MutableStateFlow(null)
     val firstMeal :MutableStateFlow<ArrayList<MealsData>?> = _firstMeal

    fun getFirstMeal(){
        viewModelScope.launch {
//            _firstMeal.value = mealsRepo.getMealsFromRemote()
            _firstMeal.emit(mealsRepo.getMealsFromRemote())
        }
    }
}