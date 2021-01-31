package com.example.android.dagger.di

import com.example.android.dagger.login.di.LoginComponent
import com.example.android.dagger.registration.di.RegistrationComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class])
class AppSubComponents {
}