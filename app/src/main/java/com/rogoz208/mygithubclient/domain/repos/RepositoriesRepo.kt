package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

interface RepositoriesRepo {

    val repositories: List<RepositoryEntity>

    fun createUser(repository: RepositoryEntity): String

    fun deleteUser(uId: String): Boolean

    fun updateUser(uId: String, repository: RepositoryEntity): Boolean
}