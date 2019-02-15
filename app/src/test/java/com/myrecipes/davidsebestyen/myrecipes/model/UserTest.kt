package com.myrecipes.davidsebestyen.myrecipes.model

import com.google.firebase.auth.FirebaseUser
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UserTest {

    lateinit var mUser: User

    @Mock
    lateinit var mUserRepository: UserRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)


    }

}