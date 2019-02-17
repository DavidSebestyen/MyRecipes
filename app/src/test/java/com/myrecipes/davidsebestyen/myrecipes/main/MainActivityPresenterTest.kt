package com.myrecipes.davidsebestyen.myrecipes.main

import com.myrecipes.davidsebestyen.myrecipes.base.BaseContract
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainActivityPresenterTest {

    lateinit var mPresenter: MainActivityPresenter

    lateinit var mView: MainContract.MvPView


    @Before
    fun setUp() {
        mPresenter = MainActivityPresenter()

        mView = mPresenter.getView()!!
    }

    @Test
    fun initUser() {
        mPresenter.initUser()

        verify(mView)?.showWelcomeUser()
    }

    @Test
    fun signOut(){
        mPresenter.signOut()
        verify(mView)?.signOut()
    }

    @Test
    fun addRecipeClicked(){
        mPresenter.addRecipeClick()

        verify(mView)?.startAddRecipeActivity(null)
    }
}