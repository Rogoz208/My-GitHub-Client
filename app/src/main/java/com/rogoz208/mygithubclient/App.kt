package com.rogoz208.mygithubclient

import android.app.Application
import com.rogoz208.mygithubclient.di.dependencies

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        dependencies()
    }
}