package com.vaxapp.repos.list

data class ViewRepo(
    val fullName: String,
    val owner: ViewOwner,
    val description: String,
    val updatedAt: String,
    val language: String?,
    val openIssuesCount: Int
)

data class ViewOwner(
    val login: String,
    val avatarUrl: String,
    val type: String
)
