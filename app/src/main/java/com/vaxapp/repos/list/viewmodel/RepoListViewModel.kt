package com.vaxapp.repos.list.viewmodel

import android.content.Intent
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.vaxapp.domain.entity.DomainRepo
import com.vaxapp.domain.interactor.GetReposUseCase
import com.vaxapp.repos.detail.RepoDetailActivity
import com.vaxapp.repos.detail.RepoDetailFragment
import com.vaxapp.repos.list.model.ViewRepo
import com.vaxapp.repos.list.model.toView
import com.vaxapp.repos.list.view.SimpleItemRecyclerViewAdapter

class RepoListViewModel(private val getReposUseCase: GetReposUseCase) : ViewModel() {

    val adapter: SimpleItemRecyclerViewAdapter =
        SimpleItemRecyclerViewAdapter(ArrayList(), this)
    val loading: ObservableInt = ObservableInt(View.GONE)
    val showEmpty: ObservableInt = ObservableInt(View.GONE)

    private val selected: MutableLiveData<ViewRepo> = MutableLiveData()
    private val liveRepos: MutableLiveData<List<ViewRepo>> = MutableLiveData()

    fun onViewReady(activity: AppCompatActivity) {
        observeRepoList(activity)
        observeSelectedItem(activity)
        fetchRepos()
    }

    @VisibleForTesting
    fun fetchRepos() {
        loading.set(View.VISIBLE)
        getReposUseCase
            .execute(onError = { doOnError() }, onSuccess = { doOnSuccess(it) })
    }

    fun getItem(position: Int): ViewRepo? {
        return liveRepos.value?.get(position)
    }

    fun onItemClick(index: Int) {
        val db = getItem(index)
        selected.value = db
    }

    private fun observeSelectedItem(activity: AppCompatActivity) {
        selected.observe(activity, Observer<ViewRepo> { it ->
            it?.let {
                val intent = Intent(activity, RepoDetailActivity::class.java)
                    .apply {
                        putExtra(RepoDetailFragment.ARG_ITEM_ID, it)
                    }
                activity.startActivity(intent)
            }
        })
    }

    private fun observeRepoList(activity: AppCompatActivity) {
        liveRepos.observe(activity, Observer<List<ViewRepo>> { it ->
            loading.set(View.GONE)
            it?.let {
                if (it.isEmpty()) {
                    showEmpty.set(View.VISIBLE)
                } else {
                    showEmpty.set(View.GONE)
                    adapter.setRepos(it)
                }
            }
        })
    }

    private fun doOnSuccess(repos: List<DomainRepo>) {
        liveRepos.value = toView(repos)
    }

    private fun doOnError() {
        liveRepos.value = emptyList()
    }
}