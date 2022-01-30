package com.rogoz208.mygithubclient.ui.screens.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo

class RepositoriesViewModelFactory(private val repositoriesRepo: RepositoriesRepo): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepositoriesViewModel(repositoriesRepo) as T
    }
}