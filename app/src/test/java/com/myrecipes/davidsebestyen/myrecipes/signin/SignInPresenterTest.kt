package com.myrecipes.davidsebestyen.myrecipes.signin

import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.lang.Exception

class SignInPresenterTest {

    lateinit var mPresenter: SignInPresenter

    @Mock
    lateinit var mView: SignInContract.MvPView

    @Mock
    lateinit var mSignInApi: SignInContract.SignInApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = SignInPresenter(mSignInApi)
    }


   @Test
   fun logInGoogle(){
       mPresenter.signInGoogleIni()

       verify(mView).signInGoogleClicked(null)
   }

    @Test
    fun onFinishedTest(){
        mPresenter.onFinished()

        verify(mView).startMainActivityIntent()
    }

    @Test
    fun onErrorTest(){
        val e = Exception()
        mPresenter.onFailure(e)

        mView.showSignInErrorMessage(e)
    }
}