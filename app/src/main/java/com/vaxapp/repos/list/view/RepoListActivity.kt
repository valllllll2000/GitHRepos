package com.vaxapp.repos.list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.vaxapp.repos.R
import com.vaxapp.repos.databinding.ActivityRepoListBinding
import com.vaxapp.repos.list.viewmodel.RepoListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class RepoListActivity : AppCompatActivity() {

    val viewModel: RepoListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.vaxapp.repos.R.layout.activity_repo_list)

        setUpBindings()
        viewModel.onViewReady(this)
    }

    private fun setUpBindings() {
        val activityBinding: ActivityRepoListBinding =
            setContentView(this, R.layout.activity_repo_list)
        activityBinding.model = viewModel
    }
}
