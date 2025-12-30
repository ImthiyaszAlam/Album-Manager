package com.imthiyas.albummanager.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imthiyas.albummanager.data.model.Album
import com.imthiyas.albummanager.data.repository.AlbumRepository

class AlbumViewModel: ViewModel() {
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    fun loadAlbums(list: List<Album>) {
        AlbumRepository.setAlbums(list)
        _albums.value = list
    }

    fun filter(query: String) {
        _albums.value = AlbumRepository.getAlbums().filter {
            it.title.contains(query, true) ||
                    it.singers.any { s -> s.contains(query, true) }
        }
    }
}