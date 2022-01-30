package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

interface RepositoriesRepo {

    fun getRepositories(callback: (List<RepositoryEntity>) -> Unit)

    fun createRepository(repository: RepositoryEntity)

    fun deleteRepository(uId: String)

    fun updateRepository(uId: String, repository: RepositoryEntity, position: Int)
}