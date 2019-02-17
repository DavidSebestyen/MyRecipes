package com.myrecipes.davidsebestyen.myrecipes.model.recipe

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(@PrimaryKey(autoGenerate = true) var id: String = "",
                  @ColumnInfo(name = "name") var name: String = "") {
}