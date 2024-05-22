package com.example.gitrepositoryfinderapplication.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {

	companion object {
		private const val BASE_URL = "https://api.github.com/"

		private val retrofit by lazy {
			val logging = HttpLoggingInterceptor()
			logging.setLevel(HttpLoggingInterceptor.Level.BODY)
			val client = OkHttpClient.Builder()
				.addInterceptor(logging)
				.build()
			Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build()
		}

		val api by lazy {
			retrofit.create(ApiService::class.java)
		}
	}
}