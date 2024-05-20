package com.example.gitrepositoryfinderapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepositoryfinderapplication.GitRepository
import com.example.gitrepositoryfinderapplication.R

class GitRepositoriesAdapter :
	RecyclerView.Adapter<GitRepositoriesAdapter.GitRepositoryViewHolder>() {

	inner class GitRepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

	private val differCallback = object : DiffUtil.ItemCallback<GitRepository>() {
		override fun areItemsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
			return oldItem.id == newItem.id
		}

		override fun areContentsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
			return oldItem == newItem
		}
	}

	val differ = AsyncListDiffer(this, differCallback)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryViewHolder {
		return GitRepositoryViewHolder(
			LayoutInflater.from(parent.context).inflate(
				R.layout.item_git_repository_preview,
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: GitRepositoryViewHolder, position: Int) {
		val gitRepository = differ.currentList[position]
		holder.itemView.apply {
//				val tvRepositoryName =  tv_name_of_repository
//
//			iv_download
		}
	}

	override fun getItemCount(): Int {
		return differ.currentList.size
	}
}