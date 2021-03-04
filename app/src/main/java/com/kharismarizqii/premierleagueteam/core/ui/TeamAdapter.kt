package com.kharismarizqii.premierleagueteam.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kharismarizqii.premierleagueteam.R
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.databinding.ItemTeamBinding

class TeamAdapter: RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private var listData = ArrayList<Team>()

    fun setData(newListData: List<Team>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    var onItemClick : ((Team) -> Unit)? = null

    inner class TeamViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemTeamBinding.bind(itemView)
        fun bind(team: Team){
            with(binding){
                tvName.text = team.name
                tvStadium.text = team.stadiumName
                Glide.with(itemView.context)
                    .load(team.badgeUrl)
                    .into(ivBadge)
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false ))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}