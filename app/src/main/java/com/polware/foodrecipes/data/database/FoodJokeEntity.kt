package com.polware.foodrecipes.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.polware.foodrecipes.data.models.FoodJoke
import com.polware.foodrecipes.data.utils.Constants.Companion.FOOD_JOKE_TABLE

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(
    /** This annotation inspect the model Class and will add his variables inside the Table */
    @Embedded
    var foodJoke: FoodJoke
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}