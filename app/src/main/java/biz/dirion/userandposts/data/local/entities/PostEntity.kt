package biz.dirion.userandposts.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "posts_table",
    primaryKeys = ["postId", "userId"],
)
data class PostEntity(
    @ColumnInfo(name = "postId")
    val postId: Long,
    @ColumnInfo(name = "userId")
    val userId: Long,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String,
)