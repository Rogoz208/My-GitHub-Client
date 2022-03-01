package com.rogoz208.mygithubclient.di

class Singleton<T>(val create: () -> T) : DependencyFactory<T> {
    private var dependency: T? = null
    override fun get(): T {
        if (dependency == null) {
            dependency = create()
        }
        return dependency!!
    }
}