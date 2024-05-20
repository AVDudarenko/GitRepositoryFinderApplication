package com.example.gitrepositoryfinderapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gitrepositoryfinderapplication.GitRepository

@Dao
interface GitRepositoryDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun upsert(gitRepository: GitRepository):Long

	@Query("SELECT * FROM repositories")
	fun getAllRepositories(): LiveData<List<GitRepository>>

}