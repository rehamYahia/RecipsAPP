package com.example.recipees.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipees.database.ResponseTable
import com.example.recipees.model.Category
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

    private val _roomMeal : MutableStateFlow<ResponseTable?> = MutableStateFlow(null)
    val roomMeal : StateFlow<ResponseTable?> = _roomMeal

    fun getFirstMeal(){
        viewModelScope.launch {
            _firstMeal.value = mealsRepo.getMealsFromRemote()
        }
    }

    fun insertData(){
        viewModelScope.launch{
            val list = mealsRepo.getMealsFromRemote().categories
        for (i in list){
            mealsRepo.insertMealToDatabase(i)
        }
        }
    }

    fun getDataFromDatabase(){
        viewModelScope.launch {
            _roomMeal.value = mealsRepo.mGetAllMealsFromDatabase()
        }
    }
}
