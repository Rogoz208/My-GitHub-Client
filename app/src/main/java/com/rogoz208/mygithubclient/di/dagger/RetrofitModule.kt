package com.rogoz208.mygithubclient.di.dagger

//import com.rogoz208.mygithubclient.data.retrofit.GithubApi
//import com.rogoz208.mygithubclient.data.retrofit.GithubRxApi
//import dagger.Module
//import dagger.Provides
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Named
//import javax.inject.Singleton
//
//@Module
//class RetrofitModule {
//
//    @Singleton
//    @Named("githubUrl")
//    @Provides
//    fun provideGithubUrl(): String = "https://api.github.com/"
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(@Named("githubUrl") githubUrl: String): Retrofit =
//        Retrofit.Builder()
//            .baseUrl(githubUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .build()
//
//    @Singleton
//    @Provides
//    fun provideGithubApi(retrofit: Retrofit): GithubApi =
//        retrofit.create(GithubApi::class.java)
//
//    @Singleton
//    @Provides
//    fun provideGithubRxApi(retrofit: Retrofit): GithubRxApi =
//        retrofit.create(GithubRxApi::class.java)
//}