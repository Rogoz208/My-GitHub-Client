package com.rogoz208.mygithubclient.data

import android.app.Application
import android.content.Context
import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"

class App : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: GithubApi = retrofit.create(GithubApi::class.java)

    val usersRepo: UsersRepo by lazy { MockUsersRepo() }
    val repositoriesRepo: RepositoriesRepo by lazy { RetrofitRepositoriesRepo(api) }
}

val Context.app: App
    get() = applicationContext as App