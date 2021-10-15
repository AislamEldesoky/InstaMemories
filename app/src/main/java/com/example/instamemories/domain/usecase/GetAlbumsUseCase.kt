package com.example.instamemories.domain.usecase

import com.example.instamemories.data.model.album.Album
import com.example.instamemories.domain.repository.AlbumRepository

class GetAlbumsUseCase (private val albumRepository: AlbumRepository) {

    suspend fun execute():List<Album>? = albumRepository.getAlbums()
}