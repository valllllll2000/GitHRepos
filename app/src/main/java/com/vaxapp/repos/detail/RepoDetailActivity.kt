package com.vaxapp.repos.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import android.view.MenuItem
import com.vaxapp.repos.R
import com.vaxapp.repos.list.RepoListActivity
import kotlinx.android.synthetic.main.activity_repo_detail.*

class RepoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val fragment = RepoDetailFragment().apply {
                arguments = Bundle().apply {
                    val extra = intent.getStringExtra(RepoDetailFragment.ARG_ITEM_ID)
                    putString(RepoDetailFragment.ARG_ITEM_ID, extra)
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpTo(this, Intent(this, RepoListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
