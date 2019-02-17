package com.myrecipes.davidsebestyen.myrecipes.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.myrecipes.davidsebestyen.myrecipes.base.BaseContract
import com.myrecipes.davidsebestyen.myrecipes.base.BasePresenter
import java.lang.Exception

class SignInPresenter(val signInApi: SignInContract.SignInApi): BasePresenter<SignInContract.MvPView>(), SignInContract.Presenter,  SignInContract.SignInApi.OnFinishedListener {


    override fun signInGoogle(acct: GoogleSignInAccount) {
        signInApi.signInGoogle(acct, this)
    }

    override fun onFinished() {
        getView()?.startMainActivityIntent()
    }

    override fun onFailure(e: Exception) {
        getView()?.showSignInErrorMessage(e)
    }


    override fun signInGoogleIni() {
        getView()?.signInGoogleClicked(null)

    }

}