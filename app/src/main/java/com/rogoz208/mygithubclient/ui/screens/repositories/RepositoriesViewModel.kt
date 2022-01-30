package com.rogoz208.mygithubclient.ui.screens.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo

class RepositoriesViewModel(private val repositoriesRepo: RepositoriesRepo) : ViewModel(),
    RepositoriesContract.ViewModel {

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as MutableLiveData<T>
    }

    override val profileUserNameLiveData: LiveData<String> = MutableLiveData()
    override val profilePictureUrlLiveData: LiveData<String> = MutableLiveData()
    override val repositoriesListLiveData: LiveData<List<RepositoryEntity>> = MutableLiveData()

    override fun getUserData(user: UserEntity) {
        profileUserNameLiveData.mutable().postValue(user.userName)
        profilePictureUrlLiveData.mutable().postValue(user.profilePictureUrl)
    }

    override fun getRepositoriesData() {
        repositoriesRepo.getRepositories { repositories ->
            repositoriesListLiveData.mutable().postValue(repositories)
        }
    }


}