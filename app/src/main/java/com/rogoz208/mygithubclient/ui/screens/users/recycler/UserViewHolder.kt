package com.rogoz208.mygithubclient.ui.screens.users.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.UserCardViewHolderBinding
import com.rogoz208.mygithubclient.domain.entities.UserEntity

class UserViewHolder(parent: ViewGroup, private val clickListener: OnItemClickListener) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.user_card_view_holder, parent, false)
    ) {
    private val binding by viewBinding(UserCardViewHolderBinding::bind)

    fun bind(user: UserEntity) {
        binding.userNameTextView.text = user.userName

        itemView.setOnClickListener {
            clickListener.onItemClick(user, this.layoutPosition)
        }

        itemView.setOnLongClickListener {
            clickListener.onItemLongClick(user, itemView, this.layoutPosition)
            true
        }
    }
}