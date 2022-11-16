package com.tkacik.lightstream.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tkacik.lightstream.databinding.ItemIndividualitemBinding

class CharAdapterRickandMorty(

    private val charContainerList: List<com.tkacik.lightstream.model.CharacterRM>,
    private val charContainerListSelected: (com.tkacik.lightstream.model.CharacterRM) -> Unit
) : RecyclerView.Adapter<CharAdapterRickandMorty.CharViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ItemIndividualitemBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
        CharViewHolder(it).apply{
            it.root.setOnClickListener{
                charContainerListSelected.invoke(charContainerList[bindingAdapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int){
        holder.load(charContainerList[position])
    }

    override fun getItemCount() = charContainerList.size

    class CharViewHolder(
        private val binding: ItemIndividualitemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun load(charContainer: com.tkacik.lightstream.model.CharacterRM) = with(binding){
            val na = "N/A"
            itemText.text = charContainer.results?.firstOrNull()?.name ?: na
        }
    }
}