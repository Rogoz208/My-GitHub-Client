package com.rogoz208.mygithubclient.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    val uId: String,
    val userName: String,
    val profilePictureUrl: String
) : Parcelable