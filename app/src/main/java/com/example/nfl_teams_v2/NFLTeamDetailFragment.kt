package com.example.nfl_teams_v2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nfl_teams_v2.databinding.FragmentNflTeamDetailBinding


class NFLTeamDetailFragment(var team: NFLTeam) : Fragment() {

    private var _binding: FragmentNflTeamDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Binding is null"
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding =
            FragmentNflTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val logoFileName = team.teamLogo.removeSuffix(".png")
            val logoResourceId = resources.getIdentifier(logoFileName, "drawable", requireContext().packageName)
            binding.teamLogoDetail.setImageResource(logoResourceId)

            teamNameDetail.text = team.teamName
            teamConferenceDetail.text = team.conference
            teamDivisionDetail.text = team.division
            teamStadiumDetail.text = team.stadiumName
            teamStadiumLatitudeDetail.text = team.latitude.toString()
            teamStadiumLongitudeDetail.text = team.longitude.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}