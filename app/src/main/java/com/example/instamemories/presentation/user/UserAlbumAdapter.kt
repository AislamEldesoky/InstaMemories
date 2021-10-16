package com.example.instamemories.presentation.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.instamemories.R
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.databinding.RecyclerViewAlbumsBinding

class UserAlbumAdapter ():RecyclerView.Adapter<MyViewHolder> (){
    private val albumsList = ArrayList<Album>()

    fun setList(albums: List<Album>){
        albumsList.clear()
        albumsList.addAll(albums)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : RecyclerViewAlbumsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.recycler_view_albums
            ,parent
            ,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(albumsList[position])
    }

    override fun getItemCount(): Int {
       return albumsList.size
    }
}

class MyViewHolder(val binding: RecyclerViewAlbumsBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(album:Album){
        binding.albumTitle.text = album.title
    }
}