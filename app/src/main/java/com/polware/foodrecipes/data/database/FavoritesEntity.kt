package com.polware.foodrecipes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.polware.foodrecipes.data.models.ResultRecipe
import com.polware.foodrecipes.data.utils.Constants.Companion.FAVORITES_TABLE

@Entity(tableName = FAVORITES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: ResultRecipe
)