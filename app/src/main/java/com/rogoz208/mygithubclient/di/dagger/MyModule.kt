package com.rogoz208.mygithubclient.di.dagger

import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.data.retrofit.GithubApi
import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class MyModule {

    @Singleton
    @Provides
    fun provideRepositoriesRepo(githubApi: GithubApi, githubRxApi: GithubRxApi): RepositoriesRepo =
        RetrofitRepositoriesRepo(githubApi, githubRxApi)

    @Singleton
    @Provides
    fun provideUsersRepo(): UsersRepo = MockUsersRepo()

    @Singleton
    @Provides
    fun provideGithubApi(retrofit: Retrofit): GithubApi =
        retrofit.create(GithubApi::class.java)

    @Singleton
    @Provides
    fun provideGithubRxApi(retrofit: Retrofit): GithubRxApi =
        retrofit.create(GithubRxApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(@Named("githubUrl") githubUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(githubUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Singleton
    @Named("githubUrl")
    @Provides
    fun provideGithubUrl(): String = "https://api.github.com/"
}