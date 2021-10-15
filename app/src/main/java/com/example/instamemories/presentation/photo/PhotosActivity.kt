package com.example.instamemories.presentation.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.instamemories.R
import com.example.instamemories.databinding.ActivityPhotosBinding

class PhotosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
    }
}