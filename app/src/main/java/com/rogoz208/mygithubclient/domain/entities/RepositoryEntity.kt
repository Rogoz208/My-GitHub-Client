package com.rogoz208.mygithubclient.domain.entities

import com.google.gson.annotations.SerializedName

data class RepositoryEntity(
    @SerializedName("id")
    val uId: Long,
    @SerializedName("full_name")
    val repositoryName: String
)