package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface UsersRepo {

    fun getUsers(callback: (List<UserEntity>) -> Unit)

    fun createUser(user: UserEntity)

    fun deleteUser(uId: String)

    fun updateUser(uId: String, user: UserEntity, position: Int)
}