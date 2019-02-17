package com.myrecipes.davidsebestyen.myrecipes.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.myrecipes.davidsebestyen.myrecipes.R
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.annotation.NonNull


abstract class BaseActivity<V: BaseContract.BaseView, P: BaseContract.BasePresenter<V>>: AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener, BaseContract.BaseView {

    lateinit var mFirebaseAuth: FirebaseAuth
    lateinit var mGoogleApiClient: GoogleApiClient


    protected val presenter: P by lazy { createPresenter() }
    protected abstract fun createPresenter(): P


    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()


        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()


    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}