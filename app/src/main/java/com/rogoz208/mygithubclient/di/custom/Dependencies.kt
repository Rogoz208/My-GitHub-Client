package com.rogoz208.mygithubclient.di.custom

import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun dependencies() {
    single("githubUrl") { "https://api.github.com/" }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>("githubUrl"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(GithubApi::class.java) }
    single { get<Retrofit>().create(GithubRxApi::class.java) }
    single<UsersRepo> { MockUsersRepo() }
    single<RepositoriesRepo> { RetrofitRepositoriesRepo(get(), get()) }
}