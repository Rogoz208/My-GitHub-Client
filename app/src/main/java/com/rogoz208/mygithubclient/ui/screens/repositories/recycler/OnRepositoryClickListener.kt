package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import android.view.View
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

interface OnRepositoryClickListener {

    fun onRepositoryClick(item: RepositoryEntity, position: Int)

    fun onRepositoryLongClick(item: RepositoryEntity, itemView: View, position: Int)
}