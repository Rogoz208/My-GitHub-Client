package com.rogoz208.mygithubclient.ui.screens.repositories

import androidx.lifecycle.LiveData
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface RepositoriesContract {

    interface ViewModel {
        val profileUserNameLiveData: LiveData<String>
        val profilePictureUrlLiveData: LiveData<String>
        val repositoriesListLiveData: LiveData<List<RepositoryEntity>>

        fun getUserData(user: UserEntity)
        fun getRepositoriesData()
    }
}