package com.kharismarizqii.premierleagueteam.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.githubuserapp.core.data.Resource
import com.kharismarizqii.premierleagueteam.MyApplication
import com.kharismarizqii.premierleagueteam.R
import com.kharismarizqii.premierleagueteam.core.ui.TeamAdapter
import com.kharismarizqii.premierleagueteam.core.ui.ViewModelFactory
import com.kharismarizqii.premierleagueteam.databinding.ActivityMainBinding
import com.kharismarizqii.premierleagueteam.detailteam.DetailTeamActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel : TeamViewModel by viewModels{
        factory
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamAdapter = TeamAdapter()
        with(binding.rvTeam){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
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
                when(team){
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
}