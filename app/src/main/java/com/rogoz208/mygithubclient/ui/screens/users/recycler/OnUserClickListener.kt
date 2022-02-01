package com.rogoz208.mygithubclient.ui.screens.users.recycler

import android.view.View
import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface OnUserClickListener {

    fun onUserClick(item: UserEntity, position: Int)

    fun onUserLongClick(item: UserEntity, itemView: View, position: Int)
}