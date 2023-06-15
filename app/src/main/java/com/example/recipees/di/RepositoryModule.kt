package com.example.recipees.di

import com.example.recipees.database.MealsDao
import com.example.recipees.network.MealsApiServices
import com.example.recipees.repo.MealsRepo
import com.example.recipees.repo.MealsRepoImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepo(mealsApiServices: MealsApiServices , MealsDao:MealsDao):MealsRepo{
        return MealsRepoImp(mealsApiServices ,MealsDao )
    }
}