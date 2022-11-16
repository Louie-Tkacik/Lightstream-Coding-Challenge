package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import com.tkacik.lightstream.R
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tkacik.lightstream.databinding.FragmentDetailsfragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detailsfragment) {
    private val args by navArgs<DetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentDetailsfragmentBinding.bind(view).apply{
            val detailsContainer = args.detailsContainer
            val na = "N/A"

        }
    }
}