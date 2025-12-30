package com.imthiyas.albummanager.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imthiyas.albummanager.data.model.Album
import com.imthiyas.albummanager.databinding.ItemAlbumBinding

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.VH>() {

    private var list = listOf<Album>()

    fun submitList(data: List<Album>) {
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VH {

        return VH(ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class VH(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onBindViewHolder(holder: VH, position: Int) {
        val album = list[position]
        holder.binding.title.text = album.title
        holder.binding.year.text = album.year.toString()
        holder.binding.singers.text = album.singers.joinToString(", ")
    }

    override fun getItemCount() = list.size
}
