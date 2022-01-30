package com.rogoz208.mygithubclient.ui.screens.users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.data.app
import com.rogoz208.mygithubclient.databinding.*
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.ui.screens.repositories.USER_EXTRA_KEY
import com.rogoz208.mygithubclient.ui.screens.repositories.UserRepositoriesActivity
import com.rogoz208.mygithubclient.ui.screens.users.recycler.OnUserClickListener
import com.rogoz208.mygithubclient.ui.screens.users.recycler.UsersAdapter
import com.rogoz208.mygithubclient.ui.screens.users.recycler.UsersDiffCallback

class UsersActivity : AppCompatActivity(R.layout.activity_users) {

    private val binding by viewBinding(ActivityUsersBinding::bind)
    private val viewModel: UsersContract.ViewModel by viewModels {
        UsersViewModelFactory(app.usersRepo)
    }

    private val adapter by lazy { UsersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        val onItemClickListener = object : OnUserClickListener {
            override fun onItemClick(item: UserEntity, position: Int) {
                viewModel.onUserClick(item)
            }

            override fun onItemLongClick(item: UserEntity, itemView: View, position: Int) {
                Toast.makeText(
                    this@UsersActivity,
                    "${item.userName} is long clicked",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        adapter.setOnItemClickListener(onItemClickListener)

        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.usersListLiveData.observe(this) { users: List<UserEntity> ->
            fillRecyclerView(users)
        }
        viewModel.openRepositoriesScreenLiveData.observe(this) { user: UserEntity ->
            openUserRepositoriesScreen(user)
        }

        viewModel.getData()
    }

    private fun fillRecyclerView(users: List<UserEntity>) {
        val usersDiffCallback = UsersDiffCallback(oldList = adapter.data, newList = users)
        val result = DiffUtil.calculateDiff(usersDiffCallback)
        adapter.data = users
        result.dispatchUpdatesTo(adapter)
    }

    private fun openUserRepositoriesScreen(user: UserEntity) {
        val intent = Intent(this, UserRepositoriesActivity::class.java)
        intent.putExtra(USER_EXTRA_KEY, user)
        startActivity(intent)
    }
}