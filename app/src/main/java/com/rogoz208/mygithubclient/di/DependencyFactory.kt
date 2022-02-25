package com.rogoz208.mygithubclient.di

interface DependencyFactory<T> {
    fun get(): T
}