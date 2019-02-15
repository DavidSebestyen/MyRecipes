package com.myrecipes.davidsebestyen.myrecipes.main

interface MainContract {

    interface MvPView {

        fun showWelcomeUser()
        fun signOut()

    }

    interface Presenter{

        fun initUser()

        fun signOut()

    }


}