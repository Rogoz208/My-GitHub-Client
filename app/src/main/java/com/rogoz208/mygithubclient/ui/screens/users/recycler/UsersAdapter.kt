package com.rogoz208.mygithubclient.ui.screens.users.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogoz208.mygithubclient.domain.entities.UserEntity

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {
    var data: List<UserEntity> = ArrayList()
        get() = ArrayList(field)

    private var clickListener: OnUserClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent, clickListener!!)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getItem(position: Int): UserEntity {
        return data[position]
    }

    fun setOnItemClickListener(listener: OnUserClickListener) {
        clickListener = listener
    }
}