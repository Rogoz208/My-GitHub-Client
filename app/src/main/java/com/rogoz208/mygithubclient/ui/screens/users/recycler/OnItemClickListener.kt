package com.rogoz208.mygithubclient.ui.screens.users.recycler

import android.view.View
import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface OnItemClickListener {

    fun onItemClick(item: UserEntity, position: Int)

    fun onItemLongClick(item: UserEntity, itemView: View, position: Int)
}