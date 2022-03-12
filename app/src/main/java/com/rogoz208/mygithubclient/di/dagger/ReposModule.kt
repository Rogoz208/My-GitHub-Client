package com.rogoz208.mygithubclient.di.dagger

import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposModule {

    @Singleton
    @Provides
    fun provideRepositoriesRepo(githubApi: GithubApi, githubRxApi: GithubRxApi): RepositoriesRepo =
        RetrofitRepositoriesRepo(githubApi, githubRxApi)

    @Singleton
    @Provides
    fun provideUsersRepo(): UsersRepo = MockUsersRepo()
}