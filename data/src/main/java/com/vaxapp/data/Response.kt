package com.vaxapp.data

data class Response(
    val items: List<ApiRepo>
)

data class ApiRepo(
    val full_name: String,
    val owner: ApiOwner,
    val description: String,
    val updated_at: String,
    val language: String,
    val open_issues_count: Int
)

data class ApiOwner(
    val login: String,
    val avatar_url: String,
    val type: String
)
