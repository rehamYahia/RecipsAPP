package com.example.recipees.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipees.model.*
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

    private val _filterMeal : MutableStateFlow<MealFilter?> = MutableStateFlow(null)
    val filterMeal : StateFlow<MealFilter?> = _filterMeal

    var roomMeal : LiveData<List<Category>>  ?= null

    private val _specificItem : MutableStateFlow<MealsDetails?> = MutableStateFlow(null)
    val specificItem : StateFlow<MealsDetails?> = _specificItem

    fun getFirstMeal(){
        viewModelScope.launch {
            _firstMeal.value = mealsRepo.getMealsFromRemote()
        }
    }

    fun getMealFilter(category:String){
        viewModelScope.launch {
            _filterMeal.value = mealsRepo.getMealFilter(category)
        }
    }

    fun insertData(category: Category){
        viewModelScope.launch{
            mealsRepo.insertMealToDatabase(category)
        }
    }

    fun getDataFromDatabase(){
        viewModelScope.launch {
            roomMeal = mealsRepo.mGetAllMealsFromDatabase()
        }
    }

    fun insertMealFilterINRoom(mealFilter: Meal , categoryName: NameCat){
        viewModelScope.launch {
            mealsRepo.insertMealFilter(mealFilter ,categoryName)
        }
    }

     fun getSpecificItem(id:Int){
        viewModelScope.launch {
            _specificItem.value = mealsRepo.getLookupMeal(id)
        }

    }
}
