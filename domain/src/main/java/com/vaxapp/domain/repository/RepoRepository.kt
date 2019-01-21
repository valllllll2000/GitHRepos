package com.vaxapp.domain.repository

import com.vaxapp.domain.entity.DomainRepo

interface RepoRepository {
    fun getRepos(onSuccess: (List<DomainRepo>) -> Unit, onError: (Throwable?) -> Unit)
}
