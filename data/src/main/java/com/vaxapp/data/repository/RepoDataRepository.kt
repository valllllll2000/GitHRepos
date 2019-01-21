package com.vaxapp.data.repository

import com.vaxapp.data.datasource.ReposDataSource
import com.vaxapp.domain.entity.DomainRepo
import com.vaxapp.domain.repository.RepoRepository

class RepoDataRepository(private val reposDataSource: ReposDataSource) :
    RepoRepository {

    override fun getRepos(onSuccess: (List<DomainRepo>) -> Unit, onError: (Throwable?) -> Unit) =
        reposDataSource.getRepos(onSuccess, onError)
}
