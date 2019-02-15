package com.myrecipes.davidsebestyen.myrecipes.firebase

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.myrecipes.davidsebestyen.myrecipes.main.MainActivity
import com.myrecipes.davidsebestyen.myrecipes.signin.SignInContract

class SignInApi: SignInContract.SignInApi {
    val firebaseAuth = FirebaseAuth.getInstance()

    override fun signInGoogle(acct: GoogleSignInAccount, onFinishedListener: SignInContract.SignInApi.OnFinishedListener) {
        Log.d("SignInApi", "fireBaseAuthWithGoogle: " + acct.id)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null) as AuthCredential
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener {
                    Log.d("SignInApi", "signInCredentialOnComplete: " + it.isSuccessful)

                    if (!it.isSuccessful) {
                        onFinishedListener.onFailure(it.exception!!)
                    } else {
                        onFinishedListener.onFinished()
                    }
                }
    }
}