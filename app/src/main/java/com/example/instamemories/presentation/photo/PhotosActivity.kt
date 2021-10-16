package com.example.instamemories.presentation.photo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instamemories.R
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.databinding.ActivityPhotosBinding
import com.example.instamemories.presentation.di.Injector
import javax.inject.Inject

class PhotosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotosBinding
    private lateinit var photoViewModel: PhotoViewModel
    private lateinit var adapter: AlbumPhotosAdapter

    @Inject
    lateinit var factory: PhotoViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photos)

        (application as Injector).createPhotoSubComponent().inject(this)

        photoViewModel = ViewModelProvider(this, this.factory).get(PhotoViewModel::class.java)
        val albumId = intent.getIntExtra("albumId", 0)
        initRecyclerView(albumId)

    }

    private fun initRecyclerView(albumId: Int) {
        binding.albumPhotos.layoutManager = GridLayoutManager(applicationContext, 3)
        adapter = AlbumPhotosAdapter()
        binding.albumPhotos.adapter = adapter

        displayPhotos(albumId)
    }

    private fun displayPhotos(albumId: Int) {
        var photosList = ArrayList<Photo>()
        val responseLiveData: LiveData<List<Photo>> = photoViewModel.getPhotos(albumId)
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                photosList = it as ArrayList<Photo>
                binding.searchText.doAfterTextChanged {
                    filter(it.toString(), photosList)
                }
            }
        })
    }

    fun filter(text: String?, photos: ArrayList<Photo>) {
        val temp: MutableList<Photo> = ArrayList()
        for (d in photos) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.title.contains(text!!)) {
                temp.add(d)
            }
        }
        //update recyclerview
        adapter.updateList(temp as ArrayList<Photo>)
    }
}