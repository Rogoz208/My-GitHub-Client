package com.rogoz208.mygithubclient.di.custom

interface DependencyFactory<T> {
    fun get(): T
}