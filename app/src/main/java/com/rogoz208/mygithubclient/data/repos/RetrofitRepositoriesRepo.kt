package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"

class RetrofitRepositoriesRepo : RepositoriesRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: GithubApi = retrofit.create(GithubApi::class.java)

    override fun getRepositories(
        userName: String,
        onSuccess: (List<RepositoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.getReposByUser(userName).enqueue(object : Callback<List<RepositoryEntity>> {
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
}