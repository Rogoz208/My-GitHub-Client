package com.rogoz208.mygithubclient.ui.screens.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.*
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.ui.screens.users.recycler.UsersAdapter
import com.rogoz208.mygithubclient.ui.screens.users.recycler.UsersDiffCallback

class UsersActivity : AppCompatActivity(R.layout.activity_users) {

    private val binding by viewBinding(ActivityUsersBinding::bind)

    private val adapter by lazy { UsersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun fillRecyclerView(users: List<UserEntity>){
        val usersDiffCallback = UsersDiffCallback(oldList = adapter.data, newList = users)
        val result = DiffUtil.calculateDiff(usersDiffCallback)
        adapter.data = users
        result.dispatchUpdatesTo(adapter)
    }
}