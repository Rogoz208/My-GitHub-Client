package com.rogoz208.mygithubclient

import android.app.Application
import android.content.Context
import com.rogoz208.mygithubclient.di.dagger.AppComponent
import com.rogoz208.mygithubclient.di.dagger.DaggerAppComponent

class App : Application() {
    val di: AppComponent by lazy { DaggerAppComponent.builder().build() }
}

val Context.app: App
    get() = applicationContext as App