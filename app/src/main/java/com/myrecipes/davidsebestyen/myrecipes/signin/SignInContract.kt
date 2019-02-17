package com.myrecipes.davidsebestyen.myrecipes.signin

import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.myrecipes.davidsebestyen.myrecipes.base.BaseContract
import com.myrecipes.davidsebestyen.myrecipes.base.BasePresenter
import java.lang.Exception

interface SignInContract {

    interface MvPView: BaseContract.BaseView {

        fun signInGoogleClicked(view: View?)

        fun startMainActivityIntent()

        fun showSignInErrorMessage(e: Exception)

    }

    interface Presenter: BaseContract.BasePresenter<MvPView> {

        fun signInGoogleIni()

        fun signInGoogle(acct: GoogleSignInAccount)

    }

    interface SignInApi{

        interface OnFinishedListener{
            fun onFinished()
            fun onFailure(e: Exception)
        }

        fun signInGoogle(acct: GoogleSignInAccount, onFinishedListener: OnFinishedListener)


    }
}