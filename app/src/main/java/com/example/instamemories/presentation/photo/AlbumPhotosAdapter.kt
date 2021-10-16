package com.example.instamemories.presentation.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.instamemories.R
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.databinding.RecyclerViewPhotosBinding
import com.squareup.picasso.Picasso

class AlbumPhotosAdapter() : RecyclerView.Adapter<PhotoViewHolder>() {
    private var photosList = ArrayList<Photo>()


    fun setList(photos: List<Photo>) {
        photosList.clear()
        photosList.addAll(photos)
    }
    fun updateList(list: ArrayList<Photo>) {
        photosList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerViewPhotosBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.recycler_view_photos, parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount(): Int {
        return photosList.size
    }
}

class PhotoViewHolder(val binding: RecyclerViewPhotosBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
       Picasso.get().load(photo.thumbnailUrl).into(binding.photo)
    }
}

