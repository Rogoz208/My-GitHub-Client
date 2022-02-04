package com.rogoz208.mygithubclient.domain.repos

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import io.reactivex.rxjava3.core.Observable

interface RepositoriesRepo {

    fun getRepositories(
        userName: String,
        onSuccess: (List<RepositoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun getRepositoriesObservable(userName: String): Observable<List<RepositoryEntity>>
}