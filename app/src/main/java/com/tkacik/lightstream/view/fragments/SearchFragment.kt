package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tkacik.lightstream.R
import com.tkacik.lightstream.databinding.FragmentSearchfragmentBinding
import com.tkacik.lightstream.util.DataStateCharacters
import com.tkacik.lightstream.util.DataStateLocations
import com.tkacik.lightstream.view.viewmodel.RickandMortyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_searchfragment) {
    private lateinit var binding: FragmentSearchfragmentBinding
    private val rickandMortyViewModel by viewModels<RickandMortyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchfragmentBinding.bind(view).apply {
            characterbutton.setOnClickListener{
                rickandMortyViewModel.loadCharacterList("characters")
            }
            locationbutton.setOnClickListener{
                rickandMortyViewModel.loadLocationList("locations")
            }
        }

    }



}