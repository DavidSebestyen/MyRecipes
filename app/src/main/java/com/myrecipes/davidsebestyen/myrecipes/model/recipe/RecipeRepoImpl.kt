package com.myrecipes.davidsebestyen.myrecipes.model.recipe

import io.reactivex.Observable
import java.util.concurrent.Callable

class RecipeRepoImpl(val recipeDao: RecipeDao): RecipeRepository {

    override fun getAllRecipe(): Observable<List<Recipe>> {
        return Observable.fromCallable(object : Callable<List<Recipe>>{
            override fun call(): List<Recipe> {
                return recipeDao.getAllRecipe()
            }

        })
    }

    override fun addRecipe(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
    }

    override fun deleteRecipe(recipe: Recipe) {
        recipeDao.deleteRecipe(recipe)
    }
}