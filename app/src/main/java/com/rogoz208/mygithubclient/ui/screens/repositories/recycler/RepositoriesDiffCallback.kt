package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import androidx.recyclerview.widget.DiffUtil
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

class RepositoriesDiffCallback(
    private val oldList: List<RepositoryEntity>,
    private val newList: List<RepositoryEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].uId == newList[newItemPosition].uId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].repositoryName == newList[newItemPosition].repositoryName
    }
}