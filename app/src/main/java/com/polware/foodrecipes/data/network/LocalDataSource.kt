package com.polware.foodrecipes.data.network

import com.polware.foodrecipes.data.database.FavoritesEntity
import com.polware.foodrecipes.data.database.FoodJokeEntity
import com.polware.foodrecipes.data.database.RecipesDao
import com.polware.foodrecipes.data.database.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val recipesDao: RecipesDao) {

    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }

    fun readFavorites(): Flow<List<FavoritesEntity>> {
        return recipesDao.readFavorites()
    }

    suspend fun insertFavorite(favoritesEntity: FavoritesEntity) {
        return recipesDao.insertFavorites(favoritesEntity)
    }

    suspend fun deleteFavorite(favoritesEntity: FavoritesEntity) {
        return recipesDao.deleteFavorite(favoritesEntity)
    }

    suspend fun deleteAllFavorites() {
        return recipesDao.deleteAllFavorites()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>> {
        return recipesDao.readFoodJoke()
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity) {
        return recipesDao.insertFoodJoke(foodJokeEntity)
    }

}