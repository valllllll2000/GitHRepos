package com.vaxapp.domain.entity


data class DomainRepo(
    val fullName: String,
    val owner: DomainOwner,
    val description: String,
    val updatedAt: String,
    val language: String,
    val openIssuesCount: Int
)

data class DomainOwner(
    val login: String,
    val avatarUrl: String,
    val type: String
)
