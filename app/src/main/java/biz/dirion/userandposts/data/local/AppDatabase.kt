package biz.dirion.userandposts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import biz.dirion.userandposts.BuildConfig
import biz.dirion.userandposts.data.local.daos.PostDao
import biz.dirion.userandposts.data.local.daos.UserDao
import biz.dirion.userandposts.data.local.entities.PostEntity
import biz.dirion.userandposts.data.local.entities.UserEntity

@Database(
    entities = [
        PostEntity::class,
        UserEntity::class,
    ],
    version = AppDatabase.DB_VERSION,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao

    companion object {
        const val DB_VERSION = 2
        const val DB_NAME = "${BuildConfig.APPLICATION_ID}:localDataBase4"
    }
}