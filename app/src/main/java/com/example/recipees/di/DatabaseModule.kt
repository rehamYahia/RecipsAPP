package com.example.recipees.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.recipees.application.HiltApplication
import com.example.recipees.database.MealsDao
import com.example.recipees.database.MealsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideDbInstance(context: Context):MealsDatabase{
//        return MealsDatabase.getInstance(context)
//    }

    @Provides
    @Singleton
    @Synchronized
    fun provideDbInstance(application: Application) :MealsDatabase{
        return Room.databaseBuilder(application , MealsDatabase::class.java , "mealDb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(mealsDatabase: MealsDatabase):MealsDao{
        return mealsDatabase.getDao()
    }
}