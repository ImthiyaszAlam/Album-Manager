package com.imthiyas.albummanager.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.imthiyas.albummanager.R
import com.imthiyas.albummanager.data.util.JsonLoader
import com.imthiyas.albummanager.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: AlbumViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val adapter = AlbumAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.loadAlbums(JsonLoader.loadAlbums(requireContext()))

        viewModel.albums.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.searchEditText.addTextChangedListener {
            viewModel.filter(it.toString())
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_createAlbumFragment
            )
        }
    }
}
