package com.example.recipees.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipees.database.EntityMeals
import com.example.recipees.database.MealOne
import com.example.recipees.model.Category
import com.example.recipees.model.Response
import com.example.recipees.repo.MealsRepo
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealsRepo: MealsRepo) :ViewModel() {
    private val _firstMeal : MutableStateFlow<Response?> = MutableStateFlow(null)
     val firstMeal : StateFlow<Response?> = _firstMeal

    private val _roomMeal : MutableStateFlow<ArrayList<EntityMeals>?> = MutableStateFlow(null)
    val roomMeal : MutableStateFlow<ArrayList<EntityMeals>?> = _roomMeal

    fun getFirstMeal(){
        viewModelScope.launch {
            _firstMeal.value = mealsRepo.getMealsFromRemote()
        }
    }

    fun insertData(mealOne: MealOne){
        viewModelScope.launch{
            mealsRepo.insertMealToDatabase(mealOne)
        }
    }

    fun getDataFromDatabase(){
        viewModelScope.launch {
            _roomMeal.value = mealsRepo.mGetAllMealsFromDatabase()
        }
    }
}
