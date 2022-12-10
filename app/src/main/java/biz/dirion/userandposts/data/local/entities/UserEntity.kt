package biz.dirion.userandposts.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "albumId")
    val albumId: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "thumbnailUrl")
    val thumbnailUrl: String,
)