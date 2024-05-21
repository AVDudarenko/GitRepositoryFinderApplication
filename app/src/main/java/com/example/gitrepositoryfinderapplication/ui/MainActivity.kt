package com.example.gitrepositoryfinderapplication.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gitrepositoryfinderapplication.R
import com.example.gitrepositoryfinderapplication.db.GitRepositoryDatabase
import com.example.gitrepositoryfinderapplication.repository.Repository
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

	lateinit var viewModel: GitRepositoryViewModel
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val repository = Repository(GitRepositoryDatabase(this))
		val viewModelProviderFactory = GitRepositoryViewModelProviderFactory(repository)
		viewModel = ViewModelProvider(
			this,
			viewModelProviderFactory
		)[GitRepositoryViewModel::class.java]

		val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
		val gitNavHostFragment = supportFragmentManager.findFragmentById(R.id.gitNavHostFragment)
		bottomNavigationView.setupWithNavController(gitNavHostFragment!!.findNavController())

	}
}