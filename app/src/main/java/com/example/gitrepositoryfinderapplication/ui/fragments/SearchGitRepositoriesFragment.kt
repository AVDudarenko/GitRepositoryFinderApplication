package com.example.gitrepositoryfinderapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepositoryfinderapplication.R
import com.example.gitrepositoryfinderapplication.adapters.GitRepositoriesAdapter
import com.example.gitrepositoryfinderapplication.db.GitRepositoryDatabase
import com.example.gitrepositoryfinderapplication.repository.Repository
import com.example.gitrepositoryfinderapplication.ui.GitRepositoryViewModelProviderFactory
import com.example.gitrepositoryfinderapplication.ui.MainActivity
import com.example.gitrepositoryfinderapplication.ui.Resource
import com.example.gitrepositoryfinderapplication.ui.viewmodel.GitRepositoryViewModel

class SearchGitRepositoriesFragment : Fragment(R.layout.fragment_search_git_repositories) {

	private lateinit var viewModelSearch: GitRepositoryViewModel
	lateinit var gitRepositoriesAdapter: GitRepositoriesAdapter

	private lateinit var etSearchField: EditText
	private lateinit var rvGitRepositories: RecyclerView
	private lateinit var paginationProgressBar: ProgressBar
	private lateinit var btnSearch: Button

	private val TAG = "SearchGitRepositoriesFragment"

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val repository = Repository(GitRepositoryDatabase(requireContext()))
		val viewModelProviderFactory = GitRepositoryViewModelProviderFactory(repository)
		viewModelSearch =
			ViewModelProvider(this, viewModelProviderFactory)[GitRepositoryViewModel::class.java]
		initViews(view)
		setupRecyclerView()

		viewModelSearch.userGitRepositories.observe(viewLifecycleOwner, Observer { response ->
			when (response) {
				is Resource.Success -> {
					hideProgressBar()
					response.data?.let { gitResponse ->
						gitRepositoriesAdapter.differ.submitList(gitResponse.gitRepositories)

					}
				}

				is Resource.Error -> {
					hideProgressBar()
					response.message?.let { message ->
						Log.e(TAG, message)
					}
				}

				is Resource.Loading -> {
					showProgressBar()
				}
			}
		})
		btnSearch.setOnClickListener {
			viewModelSearch.getUserGitRepositories(etSearchField.text.toString())
		}
	}

	private fun setupRecyclerView() {
		gitRepositoriesAdapter = GitRepositoriesAdapter()
		rvGitRepositories.apply {
			adapter = gitRepositoriesAdapter
			layoutManager = LinearLayoutManager(activity)
		}
	}

	private fun initViews(view: View) {
		etSearchField = view.findViewById(R.id.et_search_field)
		rvGitRepositories = view.findViewById(R.id.rvGitRepositories)
		paginationProgressBar = view.findViewById(R.id.paginationProgressBar)
		btnSearch = view.findViewById(R.id.btnSearch)
	}

	private fun hideProgressBar() {
		paginationProgressBar.visibility = View.INVISIBLE
	}

	private fun showProgressBar() {
		paginationProgressBar.visibility = View.VISIBLE
	}
}