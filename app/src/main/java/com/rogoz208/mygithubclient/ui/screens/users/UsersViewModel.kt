package com.rogoz208.mygithubclient.ui.screens.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy

class UsersViewModel(private val usersRepo: UsersRepo) : ViewModel(), UsersContract.ViewModel {

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as MutableLiveData<T>
    }

    override val usersListLiveData: LiveData<List<UserEntity>> = MutableLiveData()
    override val openRepositoriesScreenLiveData: LiveData<UserEntity> = MutableLiveData()


    override fun getData() {
        usersRepo.usersObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { users: List<UserEntity> ->
                    usersListLiveData.mutable().postValue(users)
                },
                onError = { t: Throwable ->
                    Log.d("@@@", t.message.orEmpty())
                }
            )
    }

    override fun onUserClick(userEntity: UserEntity) {
        openRepositoriesScreenLiveData.mutable().postValue(userEntity)
    }
}