package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.ViewHolderRepositoryCardBinding
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

class RepositoryViewHolder(
    parent: ViewGroup,
    private val clickListener: OnRepositoryClickListener
) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_repository_card, parent, false)
    ) {
    private val binding by viewBinding(ViewHolderRepositoryCardBinding::bind)

    fun bind(repository: RepositoryEntity) {
        binding.repositoryNameTextView.text = repository.repositoryName

        itemView.setOnClickListener {
            clickListener.onRepositoryClick(repository, this.layoutPosition)
        }

        itemView.setOnLongClickListener {
            clickListener.onRepositoryLongClick(repository, itemView, this.layoutPosition)
            true
        }
    }
}