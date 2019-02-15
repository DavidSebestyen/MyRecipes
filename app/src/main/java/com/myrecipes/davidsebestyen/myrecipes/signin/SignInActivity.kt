package com.myrecipes.davidsebestyen.myrecipes.signin

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.myrecipes.davidsebestyen.myrecipes.R
import com.myrecipes.davidsebestyen.myrecipes.base.BaseActivity
import com.myrecipes.davidsebestyen.myrecipes.databinding.ActivitySignInBinding
import com.myrecipes.davidsebestyen.myrecipes.firebase.SignInApi
import com.myrecipes.davidsebestyen.myrecipes.main.MainActivity
import java.lang.Exception

private const val RC_SIGN_IN = 9001

class SignInActivity : BaseActivity(), SignInContract.MvPView, GoogleApiClient.OnConnectionFailedListener {
    override fun showSignInErrorMessage(e: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val TAG = "SignInActivity"

    lateinit var mPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)

        mPresenter = SignInPresenter(this, SignInApi())
        binding.presenter = mPresenter

    }

    //MVP VIEW METHODS

    override fun signInGoogleClicked(view: View?) {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(intent, RC_SIGN_IN)

    }

    override fun startMainActivityIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d(TAG, "onConnectionFailed:" + p0.errorMessage)
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show()    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if(signInResult.isSuccess){
                val account = signInResult.signInAccount
                mPresenter.signInGoogle(account!!)
            } else {
                // Google Sign-In failed
                Log.e(TAG, "Google Sign-In failed. " + signInResult.toString());
            }
            }

    }
}