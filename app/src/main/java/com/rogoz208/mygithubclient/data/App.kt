package com.rogoz208.mygithubclient.data

import android.app.Application
import android.content.Context
import com.rogoz208.mygithubclient.data.repos.MockRepositoriesRepo
import com.rogoz208.mygithubclient.data.repos.MockUsersRepo
import com.rogoz208.mygithubclient.data.repos.RetrofitRepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.RepositoriesRepo
import com.rogoz208.mygithubclient.domain.repos.UsersRepo

class App : Application() {

    val usersRepo: UsersRepo by lazy { MockUsersRepo() }
    val repositoriesRepo: RepositoriesRepo by lazy { RetrofitRepositoriesRepo() }
}

val Context.app: App
    get() = applicationContext as App