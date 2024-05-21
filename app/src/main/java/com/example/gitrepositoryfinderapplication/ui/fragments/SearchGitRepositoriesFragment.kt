package com.example.gitrepositoryfinderapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gitrepositoryfinderapplication.R
import com.example.gitrepositoryfinderapplication.ui.MainActivity
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel

class SearchGitRepositoriesFragment : Fragment(R.layout.fragment_search_git_repositories) {

	lateinit var viewModel: GitRepositoryViewModel

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = (activity as MainActivity).viewModel
	}
}