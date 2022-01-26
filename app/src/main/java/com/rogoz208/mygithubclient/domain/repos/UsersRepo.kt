package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.UserEntity

interface UsersRepo {

    val users: List<UserEntity>

    fun createUser(user: UserEntity): String

    fun deleteUser(uId: String): Boolean

    fun updateUser(uId: String, user: UserEntity): Boolean
}