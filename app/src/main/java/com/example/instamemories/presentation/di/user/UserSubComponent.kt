package com.example.instamemories.presentation.di.user

import com.example.instamemories.presentation.user.UserActivity
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserSubComponent {

    fun inject(userActivity: UserActivity)
    @Subcomponent.Factory
    interface factory{
        fun create():UserSubComponent
    }

}