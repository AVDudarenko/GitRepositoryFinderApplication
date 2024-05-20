package com.example.gitrepositoryfinderapplication.api

import com.example.gitrepositoryfinderapplication.GitRepositoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
	@GET("users/{username}/repos")
	suspend fun getUserRepositories(@Path("username") name: String): Response<GitRepositoriesResponse>

}