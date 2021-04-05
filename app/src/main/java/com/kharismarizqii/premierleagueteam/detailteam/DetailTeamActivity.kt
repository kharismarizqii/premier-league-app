package com.kharismarizqii.premierleagueteam.detailteam

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Explode
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.core.utils.Helper.makeStatusBarTransparent
import com.kharismarizqii.premierleagueteam.databinding.ActivityDetailTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTeamActivity : AppCompatActivity() {

    private val viewModel: DetailTeamViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailTeamBinding
    private var state = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        val data = intent.getParcelableExtra<Team>(EXTRA_DATA)

        actionBar?.hide()
        makeStatusBarTransparent()

        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

                exitTransition = Explode()
                enterTransition = Explode()

            }
        }
        setContentView(binding.root)
        setUI(data)
    }

    @SuppressLint("SetTextI18n")
    private fun setUI(data: Team?) {
        if (data != null) {
            with(binding) {
                Glide.with(this@DetailTeamActivity)
                    .load(data.stadiumThumbUrl)
                    .centerCrop()
                    .into(ivBanner)

                Glide.with(this@DetailTeamActivity)
                    .load(data.badgeUrl)
                    .fitCenter()
                    .into(ivBadge)

                tvName.text = data.name
                tvYear.text = "Est. ${data.formedYear}"
                tvStadium.text = data.stadiumName
                tvDesc.text = data.desc
                Glide.with(this@DetailTeamActivity)
                    .load(data.jerseyUrl)
                    .into(ivJersey)
                tvStadiumDetail.text = data.stadiumName

                Glide.with(this@DetailTeamActivity)
                    .load(data.stadiumThumbUrl)
                    .fitCenter()
                    .into(ivStadium)

                tvLocation.text = data.stadiumLocation
                tvCapacity.text = data.stadiumCapacity
                tvStadiumDescription.text = data.stadiumDesc

                state = data.isFavorite
                setToggle(state)
                toggleFavorite.setOnClickListener {
                    state = !state
                    viewModel.setFavoriteTeam(data, state)
                    setToggle(state)
                }

            }
        }

    }

    private fun setToggle(state: Boolean) {
        binding.toggleFavorite.isChecked = state
    }
}