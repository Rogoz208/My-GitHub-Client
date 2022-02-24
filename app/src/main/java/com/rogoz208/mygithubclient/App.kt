package com.rogoz208.mygithubclient

import android.app.Application
import android.content.Context
import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRetrofit
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import retrofit2.Retrofit

class App : Application() {

    private val githubRetrofit: Retrofit by lazy { GithubRetrofit().retrofit }

    private val githubApi: GithubApi by lazy { githubRetrofit.create(GithubApi::class.java) }
    private val githubRxApi: GithubRxApi by lazy { githubRetrofit.create(GithubRxApi::class.java) }

    val usersRepo: UsersRepo by lazy { MockUsersRepo() }
    val repositoriesRepo: RepositoriesRepo by lazy {
        RetrofitRepositoriesRepo(githubApi, githubRxApi)
    }
}

val Context.app: App
    get() = applicationContext as App