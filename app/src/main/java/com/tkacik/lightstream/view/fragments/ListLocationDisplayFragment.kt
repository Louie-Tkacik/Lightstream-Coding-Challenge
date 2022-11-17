package com.tkacik.lightstream.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import com.tkacik.lightstream.R
import com.tkacik.lightstream.adapter.LocationAdapter
import com.tkacik.lightstream.databinding.FragmentListlocationdisplayfragmentBinding

@AndroidEntryPoint
class ListLocationDisplayFragment : Fragment(R.layout.fragment_listlocationdisplayfragment) {
   private val args by navArgs<ListLocationDisplayFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentListlocationdisplayfragmentBinding.bind(view).apply {
           rvRickandmorty.adapter = LocationAdapter(args.detailsLocationContainerList.toList()){
                findNavController().navigate(ListLocationDisplayFragmentDirections.goToDetail(it))
            }
        }
    }

}