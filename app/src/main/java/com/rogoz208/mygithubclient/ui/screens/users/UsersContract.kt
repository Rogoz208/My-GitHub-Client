package com.rogoz208.mygithubclient.ui.screens.users

import androidx.lifecycle.LiveData
import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface UsersContract {

    interface ViewModel {
        val usersListLiveData: LiveData<List<UserEntity>>
        val openRepositoriesScreenLiveData: LiveData<UserEntity>
        val errorMessageLiveData: LiveData<String>

        fun getData()
        fun onUserClick(userEntity: UserEntity)
    }
}