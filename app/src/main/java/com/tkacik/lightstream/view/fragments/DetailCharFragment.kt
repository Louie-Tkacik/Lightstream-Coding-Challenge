package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import com.tkacik.lightstream.R
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tkacik.lightstream.databinding.FragmentCharDetailsfragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailCharFragment : Fragment(R.layout.fragment_location_detailsfragment) {
    private val args by navArgs<DetailCharFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCharDetailsfragmentBinding.bind(view).apply{
            val detailsContainer = args.detailsCharContainer
            val na = "N/A"

        }
    }
}