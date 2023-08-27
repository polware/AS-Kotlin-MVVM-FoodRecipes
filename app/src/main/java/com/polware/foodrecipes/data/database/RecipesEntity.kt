package com.polware.foodrecipes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.polware.foodrecipes.data.models.FoodRecipe
import com.polware.foodrecipes.data.utils.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity (var foodRecipe: FoodRecipe) {
    @PrimaryKey(autoGenerate = false) // Se coloca "false" porque los datos serán sobre-escritos
    var id: Int = 0
}
