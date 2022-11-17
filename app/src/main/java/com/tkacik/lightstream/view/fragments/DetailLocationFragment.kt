package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import com.tkacik.lightstream.R
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tkacik.lightstream.databinding.FragmentLocationDetailsfragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailLocationFragment : Fragment(R.layout.fragment_location_detailsfragment) {
    private val args by navArgs<DetailLocationFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentLocationDetailsfragmentBinding.bind(view).apply{
            val detailsContainer = args.detailsLocationContainer
            val na = "N/A"

        }
    }
}