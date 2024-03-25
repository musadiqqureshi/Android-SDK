package com.example.nfl_teams_v2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nfl_teams_v2.databinding.ListItemTeamBinding

class TeamHolder(private val binding: ListItemTeamBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun bind(team: NFLTeam, onClick: (NFLTeam) -> Unit) {
        binding.teamName.text = team.teamName
        binding.teamDivision.text = team.division
        binding.teamStadium.text = team.stadiumName

        val logoFileName = team.teamLogo.removeSuffix(".png")
        val logoResourceId = context.resources.getIdentifier(logoFileName, "drawable", context.packageName)
        binding.teamLogo.setImageResource(logoResourceId)

        binding.root.setOnClickListener {
            onClick(team)
        }
    }
}

class NFLTeamListAdapter(private val teams: List<NFLTeam>, private val onClick: (NFLTeam)->Unit ) : RecyclerView.Adapter<TeamHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTeamBinding.inflate(inflater, parent, false)
        return TeamHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, onClick)
    }

    override fun getItemCount() = teams.size
}