package com.example.instamemories.presentation.di.photo

import com.example.instamemories.presentation.di.user.UserSubComponent
import com.example.instamemories.presentation.photo.PhotosActivity
import com.example.instamemories.presentation.user.UserActivity
import dagger.Subcomponent

@PhotoScope
@Subcomponent(modules = [PhotoModule::class])
interface PhotoSubComponent {


    fun inject(photosActivity: PhotosActivity)
    @Subcomponent.Factory
    interface factory{
        fun create(): PhotoSubComponent
    }

}