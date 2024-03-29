package com.rogoz208.mygithubclient.ui.screens.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UsersViewModel(private val usersRepo: UsersRepo) : ViewModel(), UsersContract.ViewModel {

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as MutableLiveData<T>
    }

    private var usersDisposable: Disposable? = null

    override val usersListLiveData: LiveData<List<UserEntity>> = MutableLiveData()
    override val openRepositoriesScreenLiveData: LiveData<UserEntity> = MutableLiveData()
    override val errorMessageLiveData: LiveData<String> = MutableLiveData()


    override fun getData() {
        usersDisposable = usersRepo.usersObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { users: List<UserEntity> ->
                    usersListLiveData.mutable().postValue(users)
                },
                onError = { t: Throwable ->
                    errorMessageLiveData.mutable().postValue(t.message)
                }
            )
    }

    override fun onUserClick(userEntity: UserEntity) {
        openRepositoriesScreenLiveData.mutable().postValue(userEntity)
    }

    override fun onCleared() {
        usersDisposable?.dispose()
        super.onCleared()
    }
}