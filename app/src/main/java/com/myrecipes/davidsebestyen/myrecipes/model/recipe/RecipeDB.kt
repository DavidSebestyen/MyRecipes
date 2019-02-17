package com.myrecipes.davidsebestyen.myrecipes.model.recipe

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDB: RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        private var INSTANCE: RecipeDB? = null

        fun getInstance(context: Context): RecipeDB?{

            if(INSTANCE == null){
                synchronized(RecipeDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            RecipeDB::class.java,
                            "recipe.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}