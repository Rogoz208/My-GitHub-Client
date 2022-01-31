package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import kotlin.collections.ArrayList

class MockRepositoriesRepo : RepositoriesRepo {
    private val cache: MutableList<RepositoryEntity> = mutableListOf()

    init {
        fillRepoByTestValues()
    }

    override fun getRepositories(
        userName: String,
        onSuccess: (List<RepositoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        onSuccess(ArrayList<RepositoryEntity>(cache))
    }
    

    private fun fillRepoByTestValues() {
        for (i in 1..10) {
            cache.add(RepositoryEntity(i.toLong(), "Repository-$i"))
        }
    }
}