package com.vaxapp.repos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vaxapp.repos.R
import kotlinx.android.synthetic.main.repo_list_content.view.*

class SimpleItemRecyclerViewAdapter(private val values: ArrayList<ViewRepo>) :
    RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
//            val item = v.tag as DummyContent.DummyItem
//            val intent = Intent(v.context, RepoDetailFragment::class.java)
//                .apply {
//                    putExtra(RepoDetailFragment.ARG_ITEM_ID, item.id)
//                }
//            v.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repo_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.fullName
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    fun setRepos(it: List<ViewRepo>) {
        values.clear()
        values.addAll(it)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.id_text
    }
}