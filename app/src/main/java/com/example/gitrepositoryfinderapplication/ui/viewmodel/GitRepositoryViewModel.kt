package com.example.gitrepositoryfinderapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitrepositoryfinderapplication.GitRepositoriesResponse
import com.example.gitrepositoryfinderapplication.GitRepository
import com.example.gitrepositoryfinderapplication.repository.Repository
import com.example.gitrepositoryfinderapplication.ui.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class GitRepositoryViewModel(val repository: Repository) : ViewModel() {

	val userGitRepositories: MutableLiveData<Resource<GitRepositoriesResponse>> = MutableLiveData()

	init {
		getUserGitRepositories("AVDudarenko")
	}

	fun getUserGitRepositories(userName: String) = viewModelScope.launch {
		userGitRepositories.postValue(Resource.Loading())
		val response = repository.getUserRepositories(userName)
		userGitRepositories.postValue(handleUserGitRepositoriesResponse(response))
	}

	private fun handleUserGitRepositoriesResponse(response: Response<GitRepositoriesResponse>): Resource<GitRepositoriesResponse> {
		if (response.isSuccessful) {
			response.body()?.let { resultResponse ->
				return Resource.Success(resultResponse)
			}
		}
		return Resource.Error(response.message())
	}

}