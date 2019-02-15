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
import com.myrecipes.davidsebestyen.myrecipes.databinding.ActivitySignInBinding
import com.myrecipes.davidsebestyen.myrecipes.main.MainActivity

private const val RC_SIGN_IN = 9001

class SignInActivity : AppCompatActivity(), SignInContract.MvPView, GoogleApiClient.OnConnectionFailedListener {


    private val TAG = "SignInActivity"



    lateinit var mFirebaseAuth: FirebaseAuth
    lateinit var mPresenter: SignInPresenter

    lateinit var mGoogleApiClient: GoogleApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)

        mPresenter = SignInPresenter(this)
        mFirebaseAuth = FirebaseAuth.getInstance()
        binding.presenter = mPresenter

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

    }

    //MVP VIEW METHODS

    override fun signInGoogleClicked(view: View?) {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(intent, RC_SIGN_IN)

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
                firebaseAuthWithGoogle(account!!);
            } else {
                // Google Sign-In failed
                Log.e(TAG, "Google Sign-In failed. " + signInResult.toString());
            }
            }

    }

    //FIrebase sign in method
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "fireBaseAuthWithGoogle: " + acct.id)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null) as AuthCredential
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener {
                    Log.d(TAG, "signInCredentialOnComplete: " + it.isSuccessful)

                    if (!it.isSuccessful) {
                        Log.w(TAG, "signInWithCredential", it.getException())
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
    }
}