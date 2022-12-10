package biz.dirion.userandposts.data

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
)