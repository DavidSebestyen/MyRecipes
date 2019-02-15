package com.myrecipes.davidsebestyen.myrecipes.main

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainActivityPresenterTest {

    lateinit var mPresenter: MainActivityPresenter

    @Mock
    lateinit var mView: MainContract.MvPView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = MainActivityPresenter(mView)
    }

    @Test
    fun initUser() {
        mPresenter.initUser()

        verify(mView).showWelcomeUser()
    }

    @Test
    fun signOut(){
        mPresenter.signOut()
        verify(mView).signOut()
    }
}