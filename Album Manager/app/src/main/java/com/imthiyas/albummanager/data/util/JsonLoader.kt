package com.imthiyas.albummanager.data.util

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.imthiyas.albummanager.data.model.Album

object JsonLoader {

    fun loadAlbums(context: Context): List<Album> {
        val json = context.assets.open("albums.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Album>>() {}.type
        return Gson().fromJson(json, type)
    }

    fun loadSingers(context: Context): List<String> {
        val json = context.assets.open("singers.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, type)
    }

}