package com.kharismarizqii.premierleagueteam.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.premierleagueteam.R
import com.kharismarizqii.premierleagueteam.core.ui.TeamAdapter
import com.kharismarizqii.premierleagueteam.detailteam.DetailTeamActivity
import com.kharismarizqii.premierleagueteam.di.FavoriteModuleDependencies
import com.kharismarizqii.premierleagueteam.favorite.databinding.ActivityFavoriteBinding
import com.kharismarizqii.premierleagueteam.favorite.di.DaggerFavoriteComponent
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel : FavoriteViewModel by viewModels{
        factory
    }

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.title_favorite)

        teamAdapter = TeamAdapter()
        with(binding.rvTeam){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = teamAdapter
        }

        teamAdapter.onItemClick = { selectedData ->
            Intent(this, DetailTeamActivity::class.java).also {
                it.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(it)
            }
        }

        viewModel.team.observe(this, { team ->
            if (team !=null){
                binding.emptyFavorite.root.visibility = if (team.isNotEmpty()) View.GONE else View.VISIBLE
                teamAdapter.setData(team)
            }
        })
    }


}