package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Observable

interface UsersRepo {

    fun getUsers(callback: (List<UserEntity>) -> Unit)

    val usersObservable: Observable<List<UserEntity>>

    fun createUser(user: UserEntity)

    fun deleteUser(uId: String)

    fun updateUser(uId: String, user: UserEntity, position: Int)
}