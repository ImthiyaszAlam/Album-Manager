package com.imthiyas.albummanager.ui.create

import androidx.lifecycle.ViewModel
import com.imthiyas.albummanager.data.model.Album
import com.imthiyas.albummanager.data.repository.AlbumRepository
import kotlin.random.Random

class CreateAlbumViewModel : ViewModel(){

    private val regex = Regex("^[a-zA-Z0-9\\-,'&#() ]+$")

    fun validateTitle(title: String) = regex.matches(title)

    fun save(title: String, year: Int, singers: List<String>) {
        AlbumRepository.addAlbum(
            Album(Random.nextInt(), title, year, singers)
        )
    }


}