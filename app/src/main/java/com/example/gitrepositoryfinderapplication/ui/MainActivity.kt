package com.example.gitrepositoryfinderapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gitrepositoryfinderapplication.R
import com.example.gitrepositoryfinderapplication.db.GitRepositoryDatabase
import com.example.gitrepositoryfinderapplication.repository.Repository
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

	lateinit var viewModelMain: GitRepositoryViewModel
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val repository = Repository(GitRepositoryDatabase(this))
		val viewModelProviderFactory = GitRepositoryViewModelProviderFactory(repository)
		viewModelMain = ViewModelProvider(
			this,
			viewModelProviderFactory
		)[GitRepositoryViewModel::class.java]

		val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
		val gitNavHostFragment = supportFragmentManager.findFragmentById(R.id.gitNavHostFragment)
		bottomNavigationView.setupWithNavController(gitNavHostFragment!!.findNavController())

	}
}