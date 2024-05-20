package com.example.gitrepositoryfinderapplication

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(
	tableName = "repositories	"
)
data class GitRepository(
	@SerializedName("id")
	val id: Int,
	@SerializedName("name")
	val name: String,
	@SerializedName("full_name")
	val fullName: String,
	@SerializedName("archive_url")
	val archiveUrl: String
)
