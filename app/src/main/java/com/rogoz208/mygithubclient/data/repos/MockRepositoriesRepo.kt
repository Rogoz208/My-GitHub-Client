package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import io.reactivex.rxjava3.core.Observable

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

    override fun getRepositoriesObservable(userName: String): Observable<List<RepositoryEntity>> {
        return Observable.empty() // todo
    }

    private fun fillRepoByTestValues() {
        for (i in 1..10) {
            cache.add(RepositoryEntity(i.toLong(), "Repository-$i"))
        }
    }
}