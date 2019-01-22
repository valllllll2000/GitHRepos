package com.vaxapp.repos.list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProviders
import com.vaxapp.repos.R
import com.vaxapp.repos.databinding.ActivityRepoListBinding
import com.vaxapp.repos.list.viewmodel.RepoListViewModel

class RepoListActivity : AppCompatActivity() {

    private var viewModel: RepoListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.vaxapp.repos.R.layout.activity_repo_list)

        setUpBindings()
        viewModel?.fetchRepos(this)
    }

    private fun setUpBindings() {
        val activityBinding: ActivityRepoListBinding =
            setContentView(this, R.layout.activity_repo_list)
        viewModel = ViewModelProviders.of(this).get(RepoListViewModel::class.java)
        activityBinding.model = viewModel
    }
}
