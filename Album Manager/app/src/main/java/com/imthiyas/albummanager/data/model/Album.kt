package com.imthiyas.albummanager.data.model

data class Album(
    val id: Int,
    val title: String,
    val year: Int,
    val singers: List<String>
)