package com.rogoz208.mygithubclient.di.dagger

import com.rogoz208.mygithubclient.ui.screens.repositories.RepositoriesActivity
import com.rogoz208.mygithubclient.ui.screens.users.UsersActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
interface MyComponent {

    fun inject(usersActivity: UsersActivity)
    fun inject(repositoriesActivity: RepositoriesActivity)
}