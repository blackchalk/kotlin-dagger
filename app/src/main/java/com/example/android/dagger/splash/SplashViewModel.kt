package com.example.android.dagger.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(val userManager: UserManager) {

    private val _splashViewState = MutableLiveData<SplashViewState>()
    val splashViewState: LiveData<SplashViewState>
        get() = _splashViewState

    fun shouldShowLogin() {
        when {
            userManager.isUserRegistered() -> _splashViewState.value = ShouldShowLogin(true)
            else ->
                _splashViewState.value = ShouldShowLogin(false)
        }
    }
}