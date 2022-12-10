package biz.dirion.userandposts.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import biz.dirion.userandposts.data.local.entities.PostEntity
import biz.dirion.userandposts.data.local.entities.UserEntity
import biz.dirion.userandposts.data.local.entities.UserWithPostsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
//    @Query("SELECT * FROM users_table")
//    fun getAll(): Flow<List<UserEntity>>
//    users_table.id AS id, " +
//    "users_table.albumId AS albumId, " +
//    "users_table.name AS name, " +
//    "users_table.url AS url, " +
//    "users_table.thumbnailUrl AS thumbnailUrl

    @Query(
        "SELECT * FROM users_table JOIN posts_table ON users_table.id = posts_table.userId"
    )
    fun getAllUsersWithPosts(): Map<UserEntity, List<PostEntity>>

    @Insert
    fun insertAll(vararg users: UserEntity)
}