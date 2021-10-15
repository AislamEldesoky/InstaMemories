package com.example.instamemories.domain.repository

import com.example.instamemories.data.model.album.Album

interface AlbumRepository {

  suspend fun  getAlbums():List<Album>
}