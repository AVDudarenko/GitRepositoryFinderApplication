package com.example.gitrepositoryfinderapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gitrepositoryfinderapplication.GitRepository

@Database(
	entities = [GitRepository::class], version = 1, exportSchema = false
)
abstract class GitRepositoryDatabase : RoomDatabase() {

	abstract fun getGitRepositoryDao(): GitRepositoryDao

	companion object {

		@Volatile
		private var INSTANCE: GitRepositoryDatabase? = null
		private val LOCK = Any()

		operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
			INSTANCE ?: createDatabase(context).also { INSTANCE = it }
		}

		private fun createDatabase(context: Context) {
			Room.databaseBuilder(
				context.applicationContext,
				GitRepositoryDatabase::class.java,
				"git_repository_db.db"
			).build()
		}
	}

}