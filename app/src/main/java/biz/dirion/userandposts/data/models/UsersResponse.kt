package biz.dirion.userandposts.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("albumId")
    val albumId: Long,
    @SerializedName("userId")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
)