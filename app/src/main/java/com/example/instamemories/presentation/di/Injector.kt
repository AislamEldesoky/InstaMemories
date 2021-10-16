package com.example.instamemories.presentation.di

import com.example.instamemories.presentation.di.photo.PhotoSubComponent
import com.example.instamemories.presentation.di.user.UserSubComponent

interface Injector {
    fun createUserSubComponent():UserSubComponent
    fun createPhotoSubComponent() : PhotoSubComponent
}