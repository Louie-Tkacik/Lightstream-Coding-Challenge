package com.tkacik.lightstream.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tkacik.lightstream.databinding.ItemIndividualitemBinding

class LocationAdapter (

    private val locationContainerList: List<com.tkacik.lightstream.model.Location>,
    private val locationContainerListSelected: (com.tkacik.lightstream.model.Location) -> Unit
    ) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>()
    {
        override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int
        ) = ItemIndividualitemBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
            LocationViewHolder(it).apply{
                it.root.setOnClickListener{
                    locationContainerListSelected.invoke(locationContainerList[bindingAdapterPosition])
                }
            }
        }

        override fun onBindViewHolder(holder: LocationViewHolder, position: Int){
            holder.load(locationContainerList[position])
        }

        override fun getItemCount() = locationContainerList.size

        class LocationViewHolder(
            private val binding: ItemIndividualitemBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun load(locationContainer: com.tkacik.lightstream.model.Location) = with(binding){
                val na = "N/A"
                itemText.text = locationContainer.results?.firstOrNull()?.name ?: na
            }
        }
    }
