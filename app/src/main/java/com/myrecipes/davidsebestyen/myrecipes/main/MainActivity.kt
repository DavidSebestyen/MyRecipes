package com.myrecipes.davidsebestyen.myrecipes.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.myrecipes.davidsebestyen.myrecipes.R
import com.myrecipes.davidsebestyen.myrecipes.base.BaseActivity
import com.myrecipes.davidsebestyen.myrecipes.databinding.ActivityMainBinding
import com.myrecipes.davidsebestyen.myrecipes.model.User
import com.myrecipes.davidsebestyen.myrecipes.signin.SignInActivity

class MainActivity : BaseActivity(), MainContract.MvPView {

    lateinit var mFirebaseUser: FirebaseUser
    lateinit var mPresenter: MainActivityPresenter

    lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mPresenter = MainActivityPresenter(this)
        mFirebaseAuth = FirebaseAuth.getInstance()
        if(mFirebaseAuth.currentUser is FirebaseUser) {
            mFirebaseUser = mFirebaseAuth.currentUser!!
            mUser = User(mFirebaseUser)
            Log.w("MainActivity", "UserDetails: " + mUser.toString() )
            showWelcomeUser()
        } else {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
            return
        }

    }

    override fun showWelcomeUser() {
        Toast.makeText(this, """ Welcome back, ${mUser.displayName}""", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.sing_out -> {
                mPresenter.signOut()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun signOut() {
        mFirebaseAuth.signOut()
        SignInActivity.startSignInActivity(this)
    }

}
