package com.rogoz208.mygithubclient.ui.screens.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.UsersRepo

class UsersViewModel(private val usersRepo: UsersRepo) : ViewModel(), UsersContract.ViewModel {

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as MutableLiveData<T>
    }

    override val usersListLiveData: LiveData<List<UserEntity>> = MutableLiveData()


    override fun getData() {
        usersRepo.getUsers { users ->
            usersListLiveData.mutable().postValue(users)
        }
    }

    override fun onUserClick(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }
}