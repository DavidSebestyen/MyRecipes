package com.myrecipes.davidsebestyen.myrecipes.model

import com.google.firebase.auth.FirebaseUser

data class User(var uid: String = "",
                var displayName: String? = "",
                var phoneNumber: String? = "",
                var recipeList: List<Recipe> = listOf()): UserRepository {

    constructor(firebaseUser: FirebaseUser): this(){
            uid = firebaseUser.uid
            displayName = firebaseUser.displayName
            phoneNumber = firebaseUser.phoneNumber

    }

}