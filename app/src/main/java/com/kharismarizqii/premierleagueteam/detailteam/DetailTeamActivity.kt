package com.kharismarizqii.premierleagueteam.detailteam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kharismarizqii.premierleagueteam.MyApplication
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.databinding.ActivityDetailTeamBinding

class DetailTeamActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Team>(EXTRA_DATA)

        setUI(data)

    }

    @SuppressLint("SetTextI18n")
    private fun setUI(data: Team?) {
        with(binding){
            Glide.with(this@DetailTeamActivity)
                .load(data?.stadiumThumbUrl)
                .centerCrop()
                .into(ivBanner)

            Glide.with(this@DetailTeamActivity)
                .load(data?.badgeUrl)
                .fitCenter()
                .into(ivBadge)

            tvName.text = data?.name
            tvYear.text = "Est. ${data?.formedYear}"
            tvStadium.text = data?.stadiumName
            tvDesc.text = data?.desc
            Glide.with(this@DetailTeamActivity)
                .load(data?.jerseyUrl)
                .into(ivJersey)
            tvStadiumDetail.text = data?.stadiumName

            Glide.with(this@DetailTeamActivity)
                .load(data?.stadiumThumbUrl)
                .fitCenter()
                .into(ivStadium)

            tvLocation.text = data?.stadiumLocation
            tvCapacity.text = data?.stadiumCapacity
            tvStadiumDescription.text = data?.stadiumDesc

        }
    }
}