package com.vaxapp.repos

import android.view.View
import com.vaxapp.domain.interactor.GetReposUseCase
import com.vaxapp.repos.list.viewmodel.RepoListViewModel
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RepoListViewModelTest {

    @Test
    fun testFetchRepos() {
        val useCase = mock(GetReposUseCase::class.java)
        doNothing().`when`(useCase).execute(any(), any())

        val viewModel = RepoListViewModel(useCase)
        viewModel.fetchRepos()

        verify(useCase).execute(any(), any())
        assertEquals(View.VISIBLE, viewModel.loading.get())
    }

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T
}
