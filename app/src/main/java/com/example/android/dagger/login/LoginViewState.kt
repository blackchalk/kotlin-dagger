package com.example.android.dagger.login

sealed class LoginViewState
object LoginSuccess : LoginViewState()
object LoginError : LoginViewState()
