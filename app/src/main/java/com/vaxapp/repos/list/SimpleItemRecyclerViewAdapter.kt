package com.vaxapp.repos.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vaxapp.repos.R
import com.vaxapp.repos.list.viewmodel.RepoListViewModel

class SimpleItemRecyclerViewAdapter(
    private val values: ArrayList<ViewRepo>,
    private var viewModel: RepoListViewModel
) :
    RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return R.layout.repo_list_content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount() = values.size

    fun setRepos(it: List<ViewRepo>) {
        values.clear()
        values.addAll(it)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: RepoListViewModel, position: Int) {
            binding.setVariable(1, viewModel)
            binding.setVariable(2, position)
        }
    }
}