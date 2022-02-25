package com.rogoz208.mygithubclient.di

class Factory<T>(val create: () -> T) : DependencyFactory<T> {
    override fun get(): T {
        return create()
    }
}