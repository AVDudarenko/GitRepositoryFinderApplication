package com.example.gitrepositoryfinderapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gitrepositoryfinderapplication.R
import com.example.gitrepositoryfinderapplication.ui.MainActivity
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel

class SavedGitRepositoriesFragment:Fragment(R.layout.fragment_saved_git_repositories) {

	private lateinit var viewModelSaved: GitRepositoryViewModel

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModelSaved = (activity as MainActivity).viewModelMain
	}
}