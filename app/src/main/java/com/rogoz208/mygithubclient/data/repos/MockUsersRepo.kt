package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import java.util.*
import kotlin.collections.ArrayList

class MockUsersRepo : UsersRepo {
    private val cache: MutableList<UserEntity> = mutableListOf()

    init {
        fillRepoByTestValues()
    }

    override fun getUsers(callback: (List<UserEntity>) -> Unit) {
        callback(ArrayList<UserEntity>(cache))
    }

    override fun createUser(user: UserEntity) {
        val newId = UUID.randomUUID().toString()
        cache.add(user.copy(uId = newId))
    }

    override fun deleteUser(uId: String) {
        for (i in cache.indices) {
            if (cache[i].uId == uId) {
                cache.removeAt(i)
            }
        }
    }

    override fun updateUser(uId: String, user: UserEntity, position: Int) {
        deleteUser(uId)
        cache.add(position, user.copy(uId = uId))
    }

    private fun fillRepoByTestValues() {
        for (i in 1..10) {
            createUser(UserEntity("", "User-$i", "https://st.depositphotos.com/2101611/3925/v/600/depositphotos_39258143-stock-illustration-businessman-avatar-profile-picture.jpg"))
        }
    }
}