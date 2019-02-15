package com.myrecipes.davidsebestyen.myrecipes.signin

import android.view.View

interface SignInContract {

    interface MvPView {

        fun signInGoogleClicked(view: View?)

    }

    interface Presenter{


        fun signInGoogle()

    }
}