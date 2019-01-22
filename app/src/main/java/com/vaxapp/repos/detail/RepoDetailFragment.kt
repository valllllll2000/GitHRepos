package com.vaxapp.repos.detail

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.vaxapp.repos.R
import com.vaxapp.repos.list.ViewRepo
import kotlinx.android.synthetic.main.activity_repo_detail.*
import kotlinx.android.synthetic.main.repo_detail_view.view.*
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class RepoDetailFragment : Fragment() {

    private var viewRepo: ViewRepo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                viewRepo = it.getParcelable(ARG_ITEM_ID)
                activity?.toolbar_layout?.title = viewRepo?.fullName
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =
            inflater.inflate(com.vaxapp.repos.R.layout.repo_detail_view, container, false)

        viewRepo?.let {
            rootView.description.text = it.description
            rootView.user_name.text = it.owner.login
            rootView.issues.text = getString(R.string.issues, it.openIssuesCount)
            rootView.language.text = it.language
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            sdf.timeZone = TimeZone.getTimeZone("GMT")
            val time = sdf.parse(it.updatedAt).time
            val now = System.currentTimeMillis()
            rootView.date.text = getString(R.string.updated,
                DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS))
            Glide.with(rootView).load(it.owner.avatarUrl).into(rootView.user_image)
            return rootView
        }
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }
}
