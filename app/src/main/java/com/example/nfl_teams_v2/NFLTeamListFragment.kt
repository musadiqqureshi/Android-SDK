package com.example.nfl_teams_v2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nfl_teams_v2.databinding.FragmentNflTeamListBinding


private const val TAG = "NFLTeamListFragment"

class NFLTeamListFragment: Fragment() {
    private var _binding: FragmentNflTeamListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val teamListViewModel: NFLTeamListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNflTeamListBinding.inflate(inflater, container, false)

        binding.teamRecyclerView.layoutManager = LinearLayoutManager(context)

        val teams = teamListViewModel.teams
        val adapter = NFLTeamListAdapter(teams, onClick =  { selectedTeam ->
            val nflTeamDetailFragment = NFLTeamDetailFragment(selectedTeam)
            val transaction=requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
            transaction.replace(R.id.fragment_container,nflTeamDetailFragment)
            transaction.commit()
        })
        binding.teamRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}