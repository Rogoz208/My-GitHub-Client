package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import java.util.*
import kotlin.collections.ArrayList

class MockRepositoriesRepo : RepositoriesRepo {
    private val cache: MutableList<RepositoryEntity> = mutableListOf()

    init {
        fillRepoByTestValues()
    }

    override fun getRepositories(callback: (List<RepositoryEntity>) -> Unit) {
        callback(ArrayList<RepositoryEntity>(cache))
    }

    override fun createRepository(repository: RepositoryEntity) {
        val newId = UUID.randomUUID().toString()
        cache.add(repository.copy(uId = newId))
    }

    override fun deleteRepository(uId: String) {
        for (i in cache.indices) {
            if (cache[i].uId == uId) {
                cache.removeAt(i)
            }
        }
    }

    override fun updateRepository(uId: String, repository: RepositoryEntity, position: Int) {
        deleteRepository(uId)
        cache.add(position, repository.copy(uId = uId))
    }

    private fun fillRepoByTestValues() {
        for (i in 1..10) {
            createRepository(RepositoryEntity("", "Repository-$i"))
        }
    }
}