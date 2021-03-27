package com.kharismarizqii.premierleagueteam.team

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.githubuserapp.core.data.Resource
import com.kharismarizqii.premierleagueteam.R
import com.kharismarizqii.premierleagueteam.core.ui.TeamAdapter
import com.kharismarizqii.premierleagueteam.databinding.ActivityMainBinding
import com.kharismarizqii.premierleagueteam.detailteam.DetailTeamActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: TeamViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamAdapter = TeamAdapter()
        with(binding.rvTeam) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = teamAdapter
        }

        teamAdapter.onItemClick = { selectedData ->
            Log.e("state", "${selectedData.isFavorite}")
            Intent(this, DetailTeamActivity::class.java).also {
                it.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(it)
            }
        }

        viewModel.team.observe(this, { team ->
            if (team != null) {
                when (team) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.GONE
                        teamAdapter.setData(team.data)
                    }

                    is Resource.Error -> {
                        binding.viewError.root.visibility = View.VISIBLE

                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite_menu -> {
                val uri = Uri.parse("premierleagueteam://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        Log.e("state", "updating state")
        teamAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("state", "updating state on restart")
        teamAdapter.notifyDataSetChanged()
    }


}