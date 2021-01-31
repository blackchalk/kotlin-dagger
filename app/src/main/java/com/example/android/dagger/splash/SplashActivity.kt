package com.example.android.dagger.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.dagger.MyApplication
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.splash.di.SplashComponent
import com.example.android.dagger.login.LoginActivity
import javax.inject.Inject

class SplashActivity: AppCompatActivity() {

    private lateinit var splashComponent: SplashComponent

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        splashComponent = (application as MyApplication).appComponent.splashComponent().create()
        splashComponent.inject(this)

        super.onCreate(savedInstanceState)

        splashViewModel.splashViewState.observe(this, Observer<SplashViewState>{ state ->
            when(state){
                is ShouldShowLogin -> {
                    if (state.shouldShowLogin){
                        intentLogin()
                    }else{
                        intentRegistration()
                    }
                }
            }
        })

        splashViewModel.shouldShowLogin()

    }

    private fun intentRegistration(){
        startActivity(Intent(this, RegistrationActivity::class.java))
        finish()
    }

    private fun intentLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}

sealed class SplashViewState
data class ShouldShowLogin(val shouldShowLogin : Boolean) : SplashViewState()