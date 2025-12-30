package com.imthiyas.albummanager.ui.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.imthiyas.albummanager.R
import com.imthiyas.albummanager.data.util.JsonLoader
import com.imthiyas.albummanager.databinding.FragmentCreateAlbumBinding

class CreateAlbumFragment : Fragment(R.layout.fragment_create_album) {

    private lateinit var binding: FragmentCreateAlbumBinding
    private val viewModel: CreateAlbumViewModel by viewModels()
    private val selectedSingers = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCreateAlbumBinding.bind(view)

        // --- Singers AutoComplete ---
        val singers = JsonLoader.loadSingers(requireContext())
        binding.singerAuto.setAdapter(
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, singers)
        )

        binding.singerAuto.setOnItemClickListener { _, _, pos, _ ->
            addChip(singers[pos])
        }

        // --- Populate Year Spinner ---
        val years = (1990..2030).map { it.toString() }
        val yearAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.yearSpinner.adapter = yearAdapter

        // --- Save Button ---
        binding.saveBtn.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val year = binding.yearSpinner.selectedItem.toString().toInt()

            if (!viewModel.validateTitle(title)) {
                binding.titleLayout.error = "Invalid title"
                return@setOnClickListener
            }

            viewModel.save(title, year, selectedSingers)
            findNavController().navigateUp()
        }
    }
    private fun addChip(name: String) {
        if (selectedSingers.contains(name)) return
        selectedSingers.add(name)

        val chip = Chip(requireContext())
        chip.text = name
        chip.isCloseIconVisible = true
        chip.setOnCloseIconClickListener {
            binding.chipGroup.removeView(chip)
            selectedSingers.remove(name)
        }
        binding.chipGroup.addView(chip)
    }
}