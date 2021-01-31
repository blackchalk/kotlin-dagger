package com.example.android.dagger.di

import com.example.android.dagger.login.di.LoginComponent
import com.example.android.dagger.registration.di.RegistrationComponent
import com.example.android.dagger.splash.di.SplashComponent
import com.example.android.dagger.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class,
    LoginComponent::class,
    SplashComponent::class,
    UserComponent::class
])
class AppSubComponents {
}