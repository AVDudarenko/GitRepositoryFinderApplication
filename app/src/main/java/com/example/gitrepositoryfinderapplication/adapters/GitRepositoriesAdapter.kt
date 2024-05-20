package com.example.gitrepositoryfinderapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
			val tvRepositoryName = findViewById<TextView>(R.id.tv_name_of_repository)
			val ivDownload = findViewById<ImageView>(R.id.iv_download)

			tvRepositoryName.text = gitRepository.name
			ivDownload.setOnClickListener {

			}
		}
	}

	override fun getItemCount(): Int {
		return differ.currentList.size
	}
}