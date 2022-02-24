package com.rogoz208.mygithubclient.ui.screens.repositories

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.app
import com.rogoz208.mygithubclient.databinding.ActivityRepositoriesBinding
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.ui.screens.repositories.recycler.OnRepositoryClickListener
import com.rogoz208.mygithubclient.ui.screens.repositories.recycler.RepositoriesAdapter
import com.rogoz208.mygithubclient.ui.screens.repositories.recycler.RepositoriesDiffCallback

const val USER_EXTRA_KEY = "USER_EXTRA_KEY"

class RepositoriesActivity : AppCompatActivity(R.layout.activity_repositories) {

    private val binding by viewBinding(ActivityRepositoriesBinding::bind)
    private val viewModel: RepositoriesContract.ViewModel by viewModels {
        RepositoriesViewModelFactory(app.repositoriesRepo)
    }

    private val adapter by lazy { RepositoriesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        val onItemClickListener = object : OnRepositoryClickListener {
            override fun onRepositoryClick(item: RepositoryEntity, position: Int) {
                Toast.makeText(
                    this@RepositoriesActivity,
                    "${item.repositoryName} is clicked",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onRepositoryLongClick(item: RepositoryEntity, itemView: View, position: Int) {
                Toast.makeText(
                    this@RepositoriesActivity,
                    "${item.repositoryName} long clicked",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        adapter.setOnItemClickListener(onItemClickListener)

        binding.repositoriesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.repositoriesRecyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.profileUserNameLiveData.observe(this) { userName: String ->
            binding.profileNameTextView.text = userName
        }

        viewModel.profilePictureUrlLiveData.observe(this) { profilePictureUrl: String ->
            Glide.with(this).load(profilePictureUrl).into(binding.profilePictureImageView)
        }

        viewModel.repositoriesListLiveData.observe(this) { repositories: List<RepositoryEntity> ->
            fillRecyclerView(repositories)
        }

        viewModel.progressLiveData.observe(this) { progress: Boolean ->
            binding.progressBar.isVisible = progress
        }

        viewModel.errorMessageLiveData.observe(this) { errorMessage: String ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }

        viewModel.getData(
            intent.getParcelableExtra(USER_EXTRA_KEY)
                ?: throw IllegalStateException("User must not be null")
        )
    }

    private fun fillRecyclerView(repositories: List<RepositoryEntity>) {
        val repositoriesDiffCallback =
            RepositoriesDiffCallback(oldList = adapter.data, newList = repositories)
        val result = DiffUtil.calculateDiff(repositoriesDiffCallback)
        adapter.data = repositories
        result.dispatchUpdatesTo(adapter)
    }
}