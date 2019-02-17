package com.myrecipes.davidsebestyen.myrecipes.main

import android.view.View
import com.myrecipes.davidsebestyen.myrecipes.base.BaseContract
import com.myrecipes.davidsebestyen.myrecipes.base.BasePresenter

interface MainContract {

    interface MvPView: BaseContract.BaseView {

        fun showWelcomeUser()
        fun signOut()
        fun startAddRecipeActivity(view: View?)

    }

    interface Presenter: BaseContract.BasePresenter<MvPView>{

        fun initUser()

        fun signOut()

        fun addRecipeClick()

    }


}