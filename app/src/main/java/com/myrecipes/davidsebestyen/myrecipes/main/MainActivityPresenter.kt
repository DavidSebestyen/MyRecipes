package com.myrecipes.davidsebestyen.myrecipes.main

import com.myrecipes.davidsebestyen.myrecipes.base.BasePresenter

class MainActivityPresenter : BasePresenter<MainContract.MvPView>(), MainContract.Presenter {
    override fun addRecipeClick() {
        getView()?.startAddRecipeActivity(null)
    }


    override fun signOut() {
        getView()?.signOut()
    }

    override fun initUser() {
        getView()?.showWelcomeUser()
    }

}