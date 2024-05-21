package com.example.gitrepositoryfinderapplication.repository

import com.example.gitrepositoryfinderapplication.api.ApiInstance
import com.example.gitrepositoryfinderapplication.db.GitRepositoryDatabase

class Repository(
	val db: GitRepositoryDatabase
) {

	suspend fun getUserRepositories(userName: String) =
		ApiInstance.api.getUserRepositories(userName)

}