package com.myrecipes.davidsebestyen.myrecipes.main

class MainActivityPresenter(val view: MainContract.MvPView) : MainContract.Presenter {
    override fun signOut() {
        view.signOut()
    }

    override fun initUser() {
        view.showWelcomeUser()
    }

}