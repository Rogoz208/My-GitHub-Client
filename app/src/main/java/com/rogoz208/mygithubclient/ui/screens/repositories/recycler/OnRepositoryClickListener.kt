package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import android.view.View
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

interface OnRepositoryClickListener {

    fun onItemClick(item: RepositoryEntity, position: Int)

    fun onItemLongClick(item: RepositoryEntity, itemView: View, position: Int)
}