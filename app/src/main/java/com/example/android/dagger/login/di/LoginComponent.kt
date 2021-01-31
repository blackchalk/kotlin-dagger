package com.example.android.dagger.login.di

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent
import com.example.android.dagger.login.LoginActivity

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
}