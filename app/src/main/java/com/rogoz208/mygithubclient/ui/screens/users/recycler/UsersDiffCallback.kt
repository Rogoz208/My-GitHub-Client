package com.rogoz208.mygithubclient.ui.screens.users.recycler

import androidx.recyclerview.widget.DiffUtil
import com.rogoz208.mygithubclient.domain.entities.UserEntity

class UsersDiffCallback(
    private val oldList: List<UserEntity>,
    private val newList: List<UserEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].uId == newList[newItemPosition].uId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].userName == newList[newItemPosition].userName
                && oldList[oldItemPosition].profilePictureUrl == newList[newItemPosition].profilePictureUrl
    }
}