package com.myrecipes.davidsebestyen.myrecipes.signin

class SignInPresenter(val view: SignInContract.MvPView): SignInContract.Presenter {


    override fun signInGoogle() {
            view.signInGoogleClicked(null)

    }
}