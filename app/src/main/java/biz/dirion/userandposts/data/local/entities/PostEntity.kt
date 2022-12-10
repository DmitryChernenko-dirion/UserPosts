package biz.dirion.userandposts.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "userId")
    val userId: Long,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String,
)