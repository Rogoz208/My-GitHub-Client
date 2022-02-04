package com.rogoz208.mygithubclient.data.retrofit

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRxApi {

    @GET("users/{user}/repos")
    fun getReposByUser(@Path("user") userName: String?): Single<List<RepositoryEntity>>
}