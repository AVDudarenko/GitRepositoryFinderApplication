package com.example.gitrepositoryfinderapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryfinderapplication.repository.Repository
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel

class GitRepositoryViewModelProviderFactory(
	private val repository: Repository
) : ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return GitRepositoryViewModel(repository) as T
	}
}