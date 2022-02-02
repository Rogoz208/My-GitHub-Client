package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepositoriesRepo(private val githubApi: GithubApi, private val githubRxApi: GithubRxApi) : RepositoriesRepo {

    override fun getRepositories(
        userName: String,
        onSuccess: (List<RepositoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        githubApi.getReposByUser(userName).enqueue(object : Callback<List<RepositoryEntity>> {
            override fun onResponse(
                call: Call<List<RepositoryEntity>>,
                response: Response<List<RepositoryEntity>>
            ) {
                onSuccess(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<RepositoryEntity>>, t: Throwable) {
                onError(t)
            }
        })
    }

    override fun getRepositoriesObservable(userName: String): Observable<List<RepositoryEntity>> {
        return githubRxApi.getReposByUser(userName).distinct()
    }
}