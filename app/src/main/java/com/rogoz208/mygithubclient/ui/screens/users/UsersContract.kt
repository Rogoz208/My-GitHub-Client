package com.rogoz208.mygithubclient.ui.screens.users

import androidx.lifecycle.LiveData
import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface UsersContract {

    interface ViewModel{
        val usersListLiveData: LiveData<List<UserEntity>>

        fun getData()
        fun onUserClick(userEntity: UserEntity)
    }
}