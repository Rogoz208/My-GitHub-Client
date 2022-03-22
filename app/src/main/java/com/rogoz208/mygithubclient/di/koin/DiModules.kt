package com.rogoz208.mygithubclient.di.koin

import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val GITHUB_URL_QUALIFIER = "githubUrl"

val reposModule = module {
    single<RepositoriesRepo> { RetrofitRepositoriesRepo(get(), get()) }
    single<UsersRepo> { MockUsersRepo() }
}

val retrofitModule = module {
    single(named(GITHUB_URL_QUALIFIER)) { "https://api.github.com/" }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named(GITHUB_URL_QUALIFIER)))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single<GithubApi> { get<Retrofit>().create(GithubApi::class.java) }
    single<GithubRxApi> { get<Retrofit>().create(GithubRxApi::class.java) }
}