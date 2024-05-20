package com.example.githubclientapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {

	companion object {
		private const val BASE_URL = "https://api.github.com/"

		fun getApiInstance(): Retrofit {
			return Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
				.build()
		}
	}

}