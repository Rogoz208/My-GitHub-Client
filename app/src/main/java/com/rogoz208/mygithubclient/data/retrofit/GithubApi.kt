package com.rogoz208.mygithubclient.data.retrofit

import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{user}/repos")
    fun getReposByUser(@Path("user") userName: String?): Call<List<RepositoryEntity>>
}