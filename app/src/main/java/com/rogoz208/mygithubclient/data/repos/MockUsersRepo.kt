package com.rogoz208.mygithubclient.data.repos

import com.rogoz208.mygithubclient.domain.entities.UserEntity
import com.rogoz208.mygithubclient.domain.repos.UsersRepo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.*

private const val RANDOM_USER_PICTURE_URL =
    "https://st.depositphotos.com/2101611/3925/v/600/depositphotos_39258143-stock-illustration-businessman-avatar-profile-picture.jpg"

class MockUsersRepo : UsersRepo {
    private val cache: MutableList<UserEntity> = mutableListOf()

    private val cacheSubject = BehaviorSubject.createDefault<List<UserEntity>>(cache)

    init {
        fillRepoByTestValues()
    }

    override fun getUsers(callback: (List<UserEntity>) -> Unit) {
        callback(ArrayList(cache))
    }

    override val usersObservable: Observable<List<UserEntity>>
        get() = cacheSubject

    override fun createUser(user: UserEntity) {
        val newId = UUID.randomUUID().toString()
        cache.add(user.copy(uId = newId))
        cacheSubject.onNext(cache)
    }

    override fun deleteUser(uId: String) {
        for (i in cache.indices) {
            if (cache[i].uId == uId) {
                cache.removeAt(i)
                cacheSubject.onNext(cache)
            }
        }
    }

    override fun updateUser(uId: String, user: UserEntity, position: Int) {
        deleteUser(uId)
        cache.add(position, user.copy(uId = uId))
        cacheSubject.onNext(cache)
    }

    private fun fillRepoByTestValues() {
        createUser(UserEntity("", "Rogoz208", RANDOM_USER_PICTURE_URL))
        for (i in 2..20) {
            createUser(UserEntity("", "User-$i", RANDOM_USER_PICTURE_URL))
        }
    }
}