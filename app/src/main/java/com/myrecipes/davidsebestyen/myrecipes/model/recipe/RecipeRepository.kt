package com.myrecipes.davidsebestyen.myrecipes.model.recipe

import android.databinding.ObservableList
import io.reactivex.Observable

interface RecipeRepository {
    fun getAllRecipe(): Observable<List<Recipe>>
    fun addRecipe(recipe: Recipe)
    fun deleteRecipe(recipe: Recipe)

}