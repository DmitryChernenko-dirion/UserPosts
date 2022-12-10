package biz.dirion.userandposts.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import biz.dirion.userandposts.data.local.entities.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM posts_table WHERE id == :userId")
    fun getPostsByUserId(userId: Long): Flow<List<PostEntity>>

    @Insert
    fun insertAll(vararg posts: PostEntity)
}