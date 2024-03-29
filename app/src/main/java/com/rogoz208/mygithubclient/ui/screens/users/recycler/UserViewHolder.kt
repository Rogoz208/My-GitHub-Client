package com.rogoz208.mygithubclient.ui.screens.users.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.ViewHolderUserCardBinding
import com.rogoz208.mygithubclient.domain.entities.UserEntity

class UserViewHolder(parent: ViewGroup, private val clickListener: OnUserClickListener) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_user_card, parent, false)
    ) {
    private val binding by viewBinding(ViewHolderUserCardBinding::bind)

    fun bind(user: UserEntity) {
        binding.userNameTextView.text = user.userName

        itemView.setOnClickListener {
            clickListener.onUserClick(user, this.layoutPosition)
        }

        itemView.setOnLongClickListener {
            clickListener.onUserLongClick(user, itemView, this.layoutPosition)
            true
        }
    }
}