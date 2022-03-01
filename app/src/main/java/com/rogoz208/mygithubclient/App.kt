package com.rogoz208.mygithubclient

import android.app.Application
import android.content.Context
import com.rogoz208.mygithubclient.di.dagger.DaggerMyComponent
import com.rogoz208.mygithubclient.di.dagger.MyComponent

class App : Application() {
    val di: MyComponent by lazy { DaggerMyComponent.builder().build() }
}

val Context.app: App
    get() = applicationContext as App