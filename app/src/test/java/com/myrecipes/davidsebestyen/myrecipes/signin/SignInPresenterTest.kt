package com.myrecipes.davidsebestyen.myrecipes.signin

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SignInPresenterTest {

    lateinit var mPresenter: SignInPresenter

    @Mock
    lateinit var mView: SignInContract.MvPView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = SignInPresenter(mView)
    }


   @Test
   fun logInGoogle(){
       mPresenter.signInGoogle()

       verify(mView).signInGoogleClicked(null)
   }
}