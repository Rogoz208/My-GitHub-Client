package com.rogoz208.mygithubclient.ui.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rogoz208.mygithubclient.domain.repos.UsersRepo

class UsersViewModelFactory(private val usersRepo: UsersRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(usersRepo) as T
    }
}