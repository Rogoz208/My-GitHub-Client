package com.rogoz208.mygithubclient.di.custom

class Factory<T>(val create: () -> T) : DependencyFactory<T> {
    override fun get(): T {
        return create()
    }
}