package com.myrecipes.davidsebestyen.myrecipes.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.myrecipes.davidsebestyen.myrecipes.R
import com.myrecipes.davidsebestyen.myrecipes.base.BaseActivity
import com.myrecipes.davidsebestyen.myrecipes.databinding.ActivityMainBinding
import com.myrecipes.davidsebestyen.myrecipes.signin.SignInActivity

class MainActivity : BaseActivity(), MainContract.MvPView {

    lateinit var mFirebaseUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mFirebaseAuth = FirebaseAuth.getInstance()
        if(mFirebaseAuth.currentUser is FirebaseUser) {
            mFirebaseUser = mFirebaseAuth.currentUser!!
        } else {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
            return
        }

    }
}
