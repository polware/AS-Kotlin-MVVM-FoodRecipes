package com.polware.foodrecipes.data.models

import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val resultsRecipe: List<ResultRecipe>
)