package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.RepositoryCardViewHolderBinding
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

class RepositoryViewHolder(
    parent: ViewGroup,
    private val clickListener: OnRepositoryClickListener
) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_card_view_holder, parent, false)
    ) {
    private val binding by viewBinding(RepositoryCardViewHolderBinding::bind)

    fun bind(repository: RepositoryEntity) {
        binding.repositoryNameTextView.text = repository.repositoryName

        itemView.setOnClickListener {
            clickListener.onItemClick(repository, this.layoutPosition)
        }

        itemView.setOnLongClickListener {
            clickListener.onItemLongClick(repository, itemView, this.layoutPosition)
            true
        }
    }
}