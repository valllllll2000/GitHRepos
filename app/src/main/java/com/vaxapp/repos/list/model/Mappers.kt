package com.vaxapp.repos.list.model

import com.vaxapp.domain.entity.DomainOwner
import com.vaxapp.domain.entity.DomainRepo

fun toView(repos: List<DomainRepo>): List<ViewRepo> {
    return repos.map { toView(it) }
}

private fun toView(repo: DomainRepo): ViewRepo = with(repo) {
    ViewRepo(
        this.fullName,
        toView(this.owner),
        this.description,
        this.updatedAt,
        this.language,
        this.openIssuesCount
    )
}

private fun toView(owner: DomainOwner): ViewOwner = with(owner) {
    ViewOwner(this.login, this.avatarUrl, this.type)
}
