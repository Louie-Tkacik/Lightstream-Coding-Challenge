package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import com.tkacik.lightstream.R
import com.tkacik.lightstream.adapter.CharAdapterRickandMorty
import com.tkacik.lightstream.databinding.FragmentListchardisplayfragmentBinding

@AndroidEntryPoint
class ListCharDisplayFragment : Fragment(R.layout.fragment_listchardisplayfragment) {
    private val args by navArgs<ListCharDisplayFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentListchardisplayfragmentBinding.bind(view).apply {
            rvRickandmorty.adapter = CharAdapterRickandMorty(args.detailsCharacterContainerList.toList()){
                findNavController().navigate(ListCharDisplayFragmentDirections.goToDetail(it))
            }
        }
    }

}