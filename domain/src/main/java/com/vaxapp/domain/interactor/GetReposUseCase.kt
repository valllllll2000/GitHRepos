package com.vaxapp.domain.interactor

import com.vaxapp.domain.entity.DomainRepo
import com.vaxapp.domain.repository.RepoRepository

class GetReposUseCase(private val repoRepository: RepoRepository) {

    fun execute(onSuccess: (List<DomainRepo>) -> Unit, onError: () -> Unit) =
        repoRepository.getRepos(onSuccess, onError)
}
