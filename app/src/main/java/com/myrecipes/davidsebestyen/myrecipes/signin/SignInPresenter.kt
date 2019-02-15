package com.myrecipes.davidsebestyen.myrecipes.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import java.lang.Exception

class SignInPresenter(val view: SignInContract.MvPView, val signInApi: SignInContract.SignInApi): SignInContract.Presenter, SignInContract.SignInApi.OnFinishedListener {
    override fun signInGoogle(acct: GoogleSignInAccount) {
        signInApi.signInGoogle(acct, this)
    }

    override fun onFinished() {
        view.startMainActivityIntent()
    }

    override fun onFailure(e: Exception) {
        view.showSignInErrorMessage(e)
    }


    override fun signInGoogleIni() {
            view.signInGoogleClicked(null)

    }
}