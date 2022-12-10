package biz.dirion.userandposts.data.di

import android.content.Context
import androidx.room.Room
import biz.dirion.userandposts.data.local.AppDatabase
import biz.dirion.userandposts.data.local.daos.PostDao
import biz.dirion.userandposts.data.local.daos.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomProvider {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase): PostDao {
        return db.postDao()
    }
}