package com.example.instamemories.domain.repository

import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import io.reactivex.Single

interface AlbumRepository {

   fun  getAlbums(userId:Int): Single<AlbumsList>
}