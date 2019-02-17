package com.myrecipes.davidsebestyen.myrecipes.model.recipe

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface RecipeDao {

    @Query("SELECT * from recipe")
    fun getAllRecipe(): List<Recipe>

    @Insert(onConflict = REPLACE)
    fun insertRecipe(recipe: Recipe)

    @Delete
    fun deleteRecipe(recipe: Recipe)

    @Query("DELETE from recipe")
    fun deleteAllRecipe()
}