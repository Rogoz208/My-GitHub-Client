package com.rogoz208.mygithubclient.di

object Di {
    private val dependenciesMap: HashMap<Qualifier, DependencyFactory<*>> = HashMap()

    fun get(qualifier: Qualifier): Any =
        dependenciesMap[qualifier]?.get() ?: throw IllegalArgumentException("Can't find such class")

    fun put(qualifier: Qualifier, dependency: DependencyFactory<*>) {
        dependenciesMap[qualifier] = dependency
    }
}

inline fun <reified T> get(): T = Di.get(Qualifier(T::class)) as T

inline fun <reified T> get(name: String): T = Di.get(Qualifier(T::class, name)) as T

inline fun <reified T> inject(): Lazy<T> = lazy { return@lazy get<T>() }

inline fun <reified T> put(dependencyFactory: DependencyFactory<T>) =
    Di.put(Qualifier(T::class), dependencyFactory)

inline fun <reified T> put(name: String, dependencyFactory: DependencyFactory<T>) =
    Di.put(Qualifier(T::class, name), dependencyFactory)

inline fun <reified T> factory(noinline function: () -> T) = put(Factory(function))

inline fun <reified T> factory(name: String, noinline function: () -> T) =
    put(name, Factory(function))

inline fun <reified T> single(noinline function: () -> T) = put(Singleton(function))

inline fun <reified T> single(name: String, noinline function: () -> T) =
    put(name, Singleton(function))