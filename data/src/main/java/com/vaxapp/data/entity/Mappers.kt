package com.vaxapp.data.entity

import com.vaxapp.domain.entity.DomainOwner
import com.vaxapp.domain.entity.DomainRepo

fun toDomain(apiResponse: ApiResponse?): List<DomainRepo> {
    return apiResponse?.let { it.items.map { toDomain(it) } } ?: emptyList()
}

private fun toDomain(source: ApiRepo): DomainRepo = with(source) {
    DomainRepo(this.full_name,
               toDomain(this.owner),
               this.description,
               this.updated_at,
               this.language,
               this.open_issues_count)
}

private fun toDomain(source: ApiOwner): DomainOwner = with(source) {
    DomainOwner(this.login, this.avatar_url, this.type)
}
