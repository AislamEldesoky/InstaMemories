package com.example.instamemories.domain.usecase

import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.domain.repository.AlbumRepository
import io.reactivex.Single

class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {
     fun execute(userId: Int): Single<AlbumsList>? {
        return albumRepository.getAlbums(userId)
    }
}