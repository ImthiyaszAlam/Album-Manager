package com.imthiyas.albummanager.data.repository

import com.imthiyas.albummanager.data.model.Album

object AlbumRepository {
    private val albums = mutableListOf<Album>()

    fun setAlbums(list: List<Album>) {
        albums.clear()
        albums.addAll(list)
    }

    fun getAlbums(): List<Album> = albums

    fun addAlbum(album: Album) {
        albums.add(album)
    }
}