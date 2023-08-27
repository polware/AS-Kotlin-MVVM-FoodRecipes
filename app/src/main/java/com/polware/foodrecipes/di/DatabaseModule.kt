package com.polware.foodrecipes.di

import android.app.Application
import androidx.room.Room
import com.polware.foodrecipes.data.database.RecipesDao
import com.polware.foodrecipes.data.database.RecipesDatabase
import com.polware.foodrecipes.data.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): RecipesDatabase {
        return Room.databaseBuilder(app, RecipesDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDao(database: RecipesDatabase): RecipesDao {
        return database.recipesDao()
    }

}