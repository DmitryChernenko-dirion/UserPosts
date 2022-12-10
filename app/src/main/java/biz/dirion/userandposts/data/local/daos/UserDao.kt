package biz.dirion.userandposts.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import biz.dirion.userandposts.data.local.entities.PostEntity
import biz.dirion.userandposts.data.local.entities.UserEntity
import biz.dirion.userandposts.data.models.UserWithPostsCount
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query(
        "SELECT " +
                "users_table.id AS id, " +
                "users_table.albumId AS albumId, " +
                "users_table.name AS name, " +
                "users_table.url AS url, " +
                "users_table.thumbnailUrl AS thumbnailUrl, " +
                "COUNT(DISTINCT postId) \"postsCount\" " +
        "FROM users_table JOIN posts_table ON users_table.id = posts_table.userId " +
        "WHERE id = :userId LIMIT 1"
    )
    fun getUser(userId: Long): Flow<UserWithPostsCount>

    @Query(
        "SELECT * FROM users_table JOIN posts_table ON users_table.id = posts_table.userId ORDER BY users_table.id"
    )
    fun getUsersWithPosts(): Flow<Map<UserEntity, List<PostEntity>>>

    @Query(
        "SELECT " +
                "users_table.id AS id, " +
                "users_table.albumId AS albumId, " +
                "users_table.name AS name, " +
                "users_table.url AS url, " +
                "users_table.thumbnailUrl AS thumbnailUrl, " +
                "COUNT(DISTINCT postId) \"postsCount\"" +
        "FROM users_table JOIN posts_table ON users_table.id = posts_table.userId " +
        "GROUP BY users_table.id"
    )
    fun getAllUserWithPostsCount(): Flow<List<UserWithPostsCount>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)
}